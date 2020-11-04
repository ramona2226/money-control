package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.TransactionRepository;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.GetTransactionsRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public final TransactionRepository transactionRepository;
    private final UserService userService;
    private final BudgetService budgetService;


    @Autowired

    public TransactionService(TransactionRepository transactionRepository, UserService userService, BudgetService budgetService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;

        this.budgetService = budgetService;
    }

    @Transactional
    public TransactionResponse createTransaction(AddTransactionRequest request) {
        LOGGER.info("Creating Transaction: {}", request);
        Transaction transaction = new Transaction();


        User user = userService.getUser(request.getUserId());

        transaction.setUser(user);
        transaction.setType(request.getType());
        transaction.setFrom(request.getFrom());
        transaction.setTo(request.getTo());
        transaction.setAmount(request.getAmount());
        transaction.setDate(request.getDate());
        transaction.setDescription(request.getDescription());


        Transaction saveTransaction = transactionRepository.save(transaction);

        budgetService.updateBudget(request.getUserId(), saveTransaction.getAmount());

        return mapTransactionResponse(saveTransaction);

    }


    // nu o folosesc din Controller pt ca imi va genera erori.
    public Transaction getTransaction(long id) {
        LOGGER.info("Retrieving transaction{}", id);


        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Budget" + id + "does not exist"));
        return transaction;
    }

    public TransactionResponse getTransactionResponse(long id) {
        Transaction transaction = getTransaction(id);

        return mapTransactionResponse(transaction);


    }


    public void deleteTransaction(long id) {
        LOGGER.info("Delete transaction{}", id);

        transactionRepository.deleteById(id);
    }

    // Query by Example
    public Page<TransactionResponse> getTransactions(GetTransactionsRequest request, Pageable pageable) {
        LOGGER.info("Retriving transactions: {}", request);
        Transaction exampleTransaction = new Transaction();
        exampleTransaction.setType(request.getType());
        exampleTransaction.setDate(request.getDate());


// exact match
        Example<Transaction> example = Example.of(exampleTransaction);
        Page<Transaction> transactionsPage = transactionRepository.findAll(example, pageable);

        List<TransactionResponse> transactionsDtos = new ArrayList<>();

        for (Transaction transaction : transactionsPage.getContent()) {
            TransactionResponse transactionResponse = mapTransactionResponse(transaction);
            transactionsDtos.add(transactionResponse);
        }

        return new PageImpl<>(transactionsDtos, pageable, transactionsPage.getTotalElements());

    }

    private TransactionResponse mapTransactionResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setId(transaction.getId());
        transactionResponse.setType(transaction.getType());
        transactionResponse.setFrom(transaction.getFrom());
        transactionResponse.setTo(transaction.getTo());
        transactionResponse.setAmount(transaction.getAmount());
        transactionResponse.setDate(transaction.getDate());
        transactionResponse.setDescription(transaction.getDescription());


        return transactionResponse;
    }

}

