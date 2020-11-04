package org.fasttrackit.moneycontrol.web;

import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.service.TransactionService;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.GetTransactionsRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @PostMapping("/{userId}")
    public ResponseEntity<TransactionResponse> createTransaction(@PathVariable long userId, @RequestBody @Valid AddTransactionRequest request) {
        TransactionResponse transaction = transactionService.createTransaction(userId, request);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Page<TransactionResponse>> getTransactions(@PathVariable long userId, Pageable pageable) {
       Page<TransactionResponse> transactions = transactionService.getTransactionsByUserId(userId, pageable);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
