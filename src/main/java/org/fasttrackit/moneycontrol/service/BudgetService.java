package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class BudgetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);

    public final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }



    public Budget createBudget(SaveBudgetRequest request) {

        LOGGER.info("Creating Budget : {}", request);

        Budget budget = new Budget();
      budgetRepository.save(budget);
        return budget;
    }

@Transactional
        public BudgetResponse getBudget(long userId) {
    LOGGER.info("Retriving available balance{}", userId);

    // lambda expression
    Budget buget= budgetRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Budget" + userId + "does not exist"));


    BudgetResponse  budgetResponse = new BudgetResponse();
    budgetResponse.setId(buget.getId());
    return budgetResponse;

}



//  public BudgetResponse updateBudget(long id, Transaction lastTransaction, SaveBudgetRequest request)
//
//      double newbalance;
//
//       Budget budget = getBudget(id);
//        double existingAvailableBalance = budget.getAvailableBalance();
//        BeanUtils.copyProperties(request, existingAvailableBalance);
//
//                newbalance = existingAvailableBalance + lastTransaction.getAmount();
//
//       budget.setAvailableBalance(newbalance);
//
//
//           return budgetRepository.save(budget);
//   }
//


    public void deleteBudget(long id) {
        LOGGER.info("Deleting user {} ", id);
        budgetRepository.deleteById(id);
    }



}
