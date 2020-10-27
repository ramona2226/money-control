package org.fasttrackit.moneycontrol.web;


import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.service.BudgetService;
import org.fasttrackit.moneycontrol.transfer.SaveBudgetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
// as pune bugdet aici la singular deoarece am un singur buget a unui user, sau pun la plural ca userul are
// buget si in lire si in euro sau  pt ca are si partea aceea cu saving cards si in lei asta daca adaug complexitate

// sau dc trebuie sa pun la plural budgets? oare de ce o sa fie mai multe bugete a mai multor useri?
@RequestMapping("bugets")
public class BudgetControler {

    private final BudgetService budgetService;

@Autowired
    public BudgetControler(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody @Valid SaveBudgetRequest request) {
    Budget budget = budgetService.createBudget(request);
    return new ResponseEntity<>(budget, HttpStatus.CREATED);

    }



}