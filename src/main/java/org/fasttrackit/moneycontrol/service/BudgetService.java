package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTrasactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



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


    public Budget addTransaction(AddTrasactionRequest request) {
        LOGGER.info("Adding transaction: {}", request);

        Budget budget = budgetRepository.findById(request.getUserId())
                .orElse(new Budget());

        if (budget.getUser() == null) {
              User user = userService.getUser(request.getUserId());
              budget.setUser(user);

          }
          return budgetRepository.save(budget);
      }


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
