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
//import org.springframework.transaction.TransactionSystemException;
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
//
//    @Autowired
//    public BudgetServiceIntegrationTests(BudgetService budgetService) {
//        this.budgetService = budgetService;
//    }
//
////
//
////    @Test
////    public void updateBudget_whenExistingBudget_ThenReturnUpdatedBudget() {
////        Budget createBudget = createBudget();
////        SaveBudgetRequest request = new SaveBudgetRequest();
////        request.setValuteName(createBudget.getValuteName() + "Euro");
////
////
////        Budget updateBudget = budgetService.updateBudget(createBudget.getId(), request);
////
////        assertThat(updateBudget, notNullValue());
////        assertThat(updateBudget.getId(), is(createBudget.getId()));
////        assertThat(updatedBudget.getBalance(), is(request.getMybudget()));
////        assertThat(updatedBudget.getValueName(), is(request.getValuteName()));
////
////    }
////}
//
//      @Test
//    public void createBudget_whenMissingBudget_ThenSaveTheBudget() {
//          SaveBudgetRequest request = new SaveBudgetRequest();
//          request.setMybudget(null);
//          request.setValuteName("euro");
//
//          Exception exception = null;
//
//          try {
//              budgetService.addBudget(request);
//          } catch (Exception e) {
//              exception = e;
//          }
//
//          assertThat(exception, notNullValue());
//          assertThat("Unexpected exception type.", exception instanceof TransactionSystemException);
//
//
//      }
//}
//
//
//        @Test
//     public void deleteBudget_whenExistingBudget_ThenTheBudgetIsDeleted
//
//
//
//


