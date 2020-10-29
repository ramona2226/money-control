package org.fasttrackit.moneycontrol.web;


import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.service.BudgetService;
import org.fasttrackit.moneycontrol.transfer.budget.BudgetResponse;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("bugets")
public class BudgetController {

    private final BudgetService budgetService;

@Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PutMapping
    public ResponseEntity<Budget> createBudget(@RequestBody @Valid SaveBudgetRequest request) {
    Budget budget = budgetService.createBudget(request);
    return new ResponseEntity<>(budget, HttpStatus.CREATED);

    }
    @GetMapping("/{userId}")
public ResponseEntity<BudgetResponse> getBudget(@PathVariable long userId) {
        BudgetResponse budget = budgetService.getBudget(userId);
        return  ResponseEntity.ok(budget);
}


//    @PutMapping("/{id}")
//    public ResponseEntity<Budget> updateBudget(@PathVariable long id, @PathVariable Transaction lastTransaction, @RequestBody  @Valid SaveBudgetRequest request) {
//    Budget budget = budgetService.updateBudget(id,  lastTransaction, request );
//
//    return ResponseEntity.ok(budget);
//}
@DeleteMapping("/{id}")
public ResponseEntity<Budget> deleteBudget(@PathVariable long id) {
budgetService.deleteBudget(id);

return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


}