//package org.fasttrackit.moneycontrol.budget;
//
//
//import org.fasttrackit.moneycontrol.domain.Budget;
//import org.fasttrackit.moneycontrol.service.BudgetService;
//import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;
//
//@SpringBootTest
//public class BudgetServiceIntegrationTests {
//
//
//    private BudgetService budgetService;
//@Autowired
//    public BudgetServiceIntegrationTests(BudgetService budgetService) {
//        this.budgetService = budgetService;
//    }
//
//    @Test
//    public void addBudget_WhenMissingBudget_thenSaveTheBudget() {
//        createBudget();
//    }
//
//    @Test
//    public void updateBudget_whenExistingBudget_ThenReturnUpdatedBudget() {
//        Budget createBudget = createBudget();
//        SaveBudgetRequest request = new SaveBudgetRequest();
//        request.setValuteName(createBudget.getValuteName() + "Euro");
//

//
//        Budget updateBudget = budgetService.updateBuget(createBudget(), request);
//
//        assertThat(updateBudget, notNullValue());
//        assertThat(updateBudget.getId(), is(createBudget.getId()));
//        assertThat(updatedBudget.get.existingAvailableBalance(), is(request.existingAvailableBalance()));
//        assertThat(updatedUser.getLastName(), is(request.getLastName()));
//
//    }

 //   }

//    private Budget createBudget() {
//        SaveBudgetRequest request = new SaveBudgetRequest();
//        request.setMybudget(600);
//        request.setValuteName("euro");
//
//
//        Budget budget = budgetService.addTransaction(request);
//
//
//        assertThat(budget, notNullValue());
//        assertThat(budget.getId(), greaterThan(0L));
//        assertThat(budget.getValuteName(), is(request.getValuteName()));
//
//
//        return budget;
//    }


  //  }




