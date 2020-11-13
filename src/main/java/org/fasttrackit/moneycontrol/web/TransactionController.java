package org.fasttrackit.moneycontrol.web;

import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.service.TransactionService;
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

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody @Valid AddTransactionRequest request) {
        TransactionResponse transaction = transactionService.createTransaction(request);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
        Transaction transaction = transactionService.getTransaction(id);
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public TransactionResponse getAllUserTransactions(@PathVariable long userId) {
        TransactionResponse allUserTransactions = transactionService.getAllUserTransactions(userId);
        return allUserTransactions;
    }


    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> getTransactions(GetTransactionsRequest request, Pageable pageable) {
      Page<TransactionResponse> transactions = transactionService.getTransactions(request, pageable);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable long id) {
        transactionService.deleteTransaction(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
