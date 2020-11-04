package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.domain.User;
import org.fasttrackit.moneycontrol.persistance.TransactionRepository;
import org.fasttrackit.moneycontrol.persistance.UserRepository;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public final UserService userService;


    @Autowired

    public TransactionService(TransactionRepository transactionRepository, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    @Transactional
    public TransactionResponse createTransaction(long userId, AddTransactionRequest request) {
        LOGGER.info("Creating Transaction: {}", request);
        Transaction transaction = new Transaction();
        transaction.setFrom(request.getFrom());
        transaction.setTo(request.getTo());
        transaction.setAmount(request.getAmount());
        transaction.setDate(request.getDate());
        transaction.setDescription(request.getDescription());


        User user = userService.getUser(userId);

        //asociem tranzactia la user
//        transaction.setUser(user);
        //vezi de ce nu vine pe saveTransaction id.
//        transaction = transactionRepository.save(transaction);

        user.setBalance(user.getBalance() + transaction.getAmount());
        userService.update(user);


        return mapTransactionResponse(transaction);
    }

    public Page<TransactionResponse> getTransactionsByUserId(long userId,  Pageable pageable) {
        LOGGER.info("Retrieving transactions for user{}", userId);
        Page<Transaction> transactionsPage = transactionRepository.findByUserId(userId, pageable);
        List<TransactionResponse> transactionsDtos = new ArrayList<>();
        for (Transaction transaction : transactionsPage.getContent()) {
            TransactionResponse transactionResponse = mapTransactionResponse(transaction);
            transactionsDtos.add(transactionResponse);
        }

        return new PageImpl<>(transactionsDtos, pageable, transactionsPage.getTotalElements());

    }

    private TransactionResponse mapTransactionResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
//        transactionResponse.setId(transaction.getId()); //de vazut
        transactionResponse.setFrom(transaction.getFrom());
        transactionResponse.setTo(transaction.getTo());
//        transactionResponse.setAmount(transaction.getAmount());//de vazut
        transactionResponse.setDate(transaction.getDate());
        transactionResponse.setDescription(transaction.getDescription());

        return transactionResponse;
    }

}

