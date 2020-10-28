package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.SaveBudgetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


        public Budget getBudget(long id) {
            LOGGER.info("Retriving available balance{}", id);
//aici am un wearnind  in care imi spune ca "budget" is redundat. la  ce anume se refera oare?
            Budget budget = budgetRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Budget" + id + "does not exist"));
            return budget;


        }
            public void updateBudget(long id, Transaction lastTransaction, SaveBudgetRequest request) {
      double newbalance;

       Budget budget = getBudget(id);
        double existingAvailableBalance = budget.getAvailableBalance();
        //BeanUtils.copyProperties(request, existingAvailableBalance);

                newbalance = existingAvailableBalance + lastTransaction.getAmount();

       budget.setAvailableBalance(newbalance);

           // return budgetRepository.save(budget);
   }



    public void deleteBudget(long id) {
        LOGGER.info("Deleting user {} ", id);
        budgetRepository.deleteById(id);
    }




}
