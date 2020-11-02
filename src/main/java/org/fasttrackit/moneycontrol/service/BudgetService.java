package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTrasactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


@Transactional
    public BudgetResponse getBudget(long userId) {
        LOGGER.info("Retrieving budget {}", userId);
        Budget budget = BudgetRepository.findbyId(userId)
                .orElseThrow() -> new ResourceNotFoundException("Budget" + userId + "does not exist."));
        BudgetRepository budgetRepository =  new BudgetRepository();
        budgetRepository.setId(budget.getId());
        return budgetRepository;
    }

    @Transactional
    public Budget addTransaction(AddTrasactionRequest request) {

        LOGGER.info("Retriving  balance: {}", request);

        // lambda expression
        Budget budget = budgetRepository.findById(request.getUserId())
                .orElse(new Budget());


        if (budget.getUser() == null) {
            Budget budget = BudgetService.getUser(request.getUserId());
            budget.setUser(user);

            // add transaction to budget
            return budgetRepository.save(budget);

        }


}


        public void deleteBudget ( long id){
            LOGGER.info("Deleting user {} ", id);
            budgetRepository.deleteById(id);
        }


    }