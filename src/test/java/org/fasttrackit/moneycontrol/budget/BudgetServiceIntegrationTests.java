package org.fasttrackit.moneycontrol.budget;


import org.fasttrackit.moneycontrol.service.BudgetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BudgetServiceIntegrationTests {


    private BudgetService budgetService;
@Autowired
    public BudgetServiceIntegrationTests(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    @Test
    public void addBudget_WhenValidRequest_thenSaveTheBudget() {

    budgetService.addBudget(request);
    }



}
