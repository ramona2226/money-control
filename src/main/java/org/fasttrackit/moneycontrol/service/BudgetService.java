package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



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

public Budget addBudget(AddTransactionRequest request) {

        LOGGER.info("Adding money to my budget: {}", request);

        Budget budget = budgetRepository.findById(request.getUserId())
        .orElse(new Budget());

        if (budget.getUser() == null) {
            User user  = userService.getUser(request.getUserId());
            budget.setUser(user);

        }
        // add product to card
return  budgetRepository.save(budget);

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

  public  Budget updateBudget(long id, Transaction lastTransaction, SaveBudgetRequest request) {


      double availableBalance;

      LOGGER.info("Updating budget {}: {} {}", id, lastTransaction, request);

      BudgetResponse budget = getBudget(id);
      double existingBalance = budget.getBalance();
      BeanUtils.copyProperties(request, existingBalance);

      availableBalance = existingBalance + lastTransaction.getAmount();


     return  budgetRepository.save(budget);

  }


    public void deleteBudget(long id) {
        LOGGER.info("Deleting user {} ", id);
        budgetRepository.deleteById(id);
    }


    }