package org.fasttrackit.moneycontrol.web;


import org.fasttrackit.moneycontrol.service.BudgetService;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("budgets")
public class BudgetController {

    private final BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<BudgetResponse> getBudget(@PathVariable long userId) {
        BudgetResponse budget = budgetService.getBudget(userId);


        return ResponseEntity.ok(budget);
    }
}


