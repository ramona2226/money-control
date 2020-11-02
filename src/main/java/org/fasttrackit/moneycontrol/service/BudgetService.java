package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.transaction.CreateOrAddTransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.Valid;


@Service
public class BudgetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);

    @Autowired
    public final BudgetRepository budgetRepository;
    public final UserService userService;


    public BudgetService(BudgetRepository budgetRepository, UserService userService) {
        this.budgetRepository = budgetRepository;
        this.userService = userService;
}
    public Budget createBudget(@Valid CreateOrAddTransactionRequest request) {

        LOGGER.info("Creating Budget : {}", request);

        Budget budget = new Budget();
        budgetRepository.save(budget);
        return budget;
    }

    @Transactional
    public BudgetResponse getBudget(long userId) {
        LOGGER.info("Retriving available balance{}", userId);

        // lambda expression
        Budget buget = budgetRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Budget" + userId + "does not exist"));


        BudgetResponse budgetResponse = new BudgetResponse();
        budgetResponse.setId(buget.getId());
        return budgetResponse;

    }

//  public Budget updateBudget(long id, Transaction lastTransaction, SaveBudgetRequest request) {
//
//      double newbalance;
//
//       BudgetResponse budget = getBudget(id);
//        double balance = budget.getbalance();
//        BeanUtils.copyProperties(request, balance);
//
//                newbalance = existingAvailableBalance + lastTransaction.getAmount();
//
//       budget.setAvailableBalance(newbalance);
//
//
//           return budgetRepository.save(budget);
//   }




    public void deleteBudget(long id) {
        LOGGER.info("Deleting user {} ", id);
        budgetRepository.deleteById(id);
    }


    }