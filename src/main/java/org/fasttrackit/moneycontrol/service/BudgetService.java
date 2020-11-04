package org.fasttrackit.moneycontrol.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.fasttrackit.moneycontrol.transfer.budget.TransactionInBudget;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;



@Service
public class BudgetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);

    @Autowired
    public final BudgetRepository budgetRepository;
    public final UserService userService;
    public final TransactionService transactionService;


    public BudgetService(BudgetRepository budgetRepository, UserService userService, TransactionService transactionService) {
        this.budgetRepository = budgetRepository;
        this.userService = userService;
        this.transactionService = transactionService;

    }

    @Transactional
    public Budget addBudget(AddTransactionRequest request) {

        LOGGER.info("Adding money to my budget: {}", request);

        Budget budget = budgetRepository.findById(request.getUserId())
                .orElse(new Budget());

        if (budget.getUser() == null) {
            User user = userService.getUser(request.getUserId());
            budget.setUser(user);

        }
        Transaction transaction = transactionService.getTransaction(request.getTransactionId());

        budget.addTransaction(transaction);

        // add product to card
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

        Set<TransactionInBudget> transactions = new HashSet<>();

        for (Transaction transaction : buget.getTransactions()) {
            TransactionInBudget transactionInBudget = new TransactionInBudget();
            transactionInBudget.setId(transaction.getId());
            transaction.setType(transaction.getType());
            transactionInBudget.setAmount(transaction.getAmount());
            transactionInBudget.setDate(transaction.getDate());

            transactions.add(transactionInBudget);
        }


        budgetResponse.setTransactions(transactions);

        return budgetResponse;

    }

    public Budget updateBudget(long userId, AddTransactionRequest request) {
        LOGGER.info("Updating Budget {}: {} {}", userId, request);
//        83 - ramona

//        Budget budget = budgetRepository.findByUserId(userId)
       Budget budget = budgetRepository.findById(userId)
               .orElseThrow(() -> new ResourceNotFoundException("Budget" + userId + "does not exist"));
       if (budget == null) {
           budget = new Budget();
           budget.setId(userId);
           budget.setBalance(0);
       }
        double newBalance = budget.getBalance() + request.getAmount();
        budget.setBalance(newBalance);
//       BeanUtils.copyProperties(request, existingBudget);

        return budgetRepository.save(budget);
    }

    public void deleteBudget(long id) {
        LOGGER.info("Deleting user {} ", id);
        budgetRepository.deleteById(id);
    }

}

