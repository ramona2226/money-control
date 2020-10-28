package org.fasttrackit.moneycontrol.web;

import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.service.TransactionService;
import org.fasttrackit.moneycontrol.transfer.SaveBudgetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("transactions")

public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid SaveBudgetRequest request) {
        Transaction transaction = transactionService.createTransaction(request);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> readTransaction(@PathVariable long id){
        Transaction transaction = transactionService.getTransaction(id);
        return ResponseEntity.ok(transaction);

    }
        @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable long id) {
         transactionService.deleteTransaction(id);

    return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
