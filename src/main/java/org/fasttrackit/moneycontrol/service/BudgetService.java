package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;


@Service
public class BudgetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);


    public final BudgetRepository budgetRepository;
    public final UserService userService;


    @Autowired
    public BudgetService(BudgetRepository budgetRepository, UserService userService) {
        this.budgetRepository = budgetRepository;
        this.userService = userService;


    }


    @Transactional
    public BudgetResponse getBudget(long userId) {
        LOGGER.info("Retriving available balance{}", userId);

        // lambda expression
        Budget budget = budgetRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Budget" + userId + "does not exist"));


        BudgetResponse budgetResponse = new BudgetResponse();
        budgetResponse.setId(budget.getId());
        budgetResponse.setBalance(budget.getBalance());
        budgetResponse.setValuteName(budget.getValuteName());


        return budgetResponse;

    }

    public Budget updateBudget(long userId, @Valid double amount) {
        LOGGER.info("Updating Budget {} with amount {}", userId, amount);

        Budget budget = budgetRepository.findById(userId)
                .orElse(new Budget());

        if (budget.getUser() == null) {
            User user = userService.getUser(userId);
            budget.setUser(user);
        }

        double newBalance = budget.getBalance() + amount;
        budget.setBalance(newBalance);
        budget.setValuteName("EUR");



        return budgetRepository.save(budget);
    }


}

