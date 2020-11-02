//package org.fasttrackit.moneycontrol.steps;
//
//import org.fasttrackit.moneycontrol.domain.Budget;
//import org.fasttrackit.moneycontrol.service.BudgetService;
//import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;
//
//
//@Component
//
//public class BudgetTestSteps {
//
//
//        @Autowired
//        private BudgetService budgetService;
//
//
//        public Budget addBudget() {
//            SaveBudgetRequest request = new SaveBudgetRequest()
//            request.setMybudget(2000);
//            request.setValuteName("Euro");
//
//
//            Budget budget = budgetService.addBudget(request);
//
//            assertThat(budget, notNullValue());
//            assertThat(budget.getId(), greaterThan(0L));
//            assertThat(budget.getValuteName(), is(request.getValuteName()));
//
//
//            return budget;
//        }
//
//}
