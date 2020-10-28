package org.fasttrackit.moneycontrol.service;


import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.TransactionRepository;
import org.fasttrackit.moneycontrol.transfer.SaveBudgetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class TransactionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
// am pus void sa nu imi dea eroare de compilare pana   rezolv cu baza de date.
    public void createTransaction(SaveBudgetRequest request) {
        LOGGER.info("Creating Transaction: {}", request);

        Transaction transaction = new Transaction();

        //  return transactionRepository.save(transaction);

    }

    public Budget getTransaction(long id) {
        LOGGER.info("Retrieving transaction{}", id);

// aici mi-a sugerat sa pun Budget si nu Transaction transaction si nu inteleg de ce.
        Budget transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Budget" + id + "does not exist"));
       return transaction;
    }

    // nu stiu oare are sens sa pun su un update o metoda update, gen in viata reala
    // odata ce ai facut o plata nu poti sa o schimbi.  insa poate ar trebuii sa includ toate   metodele CRUD


    public void deleteTransaction(long id) {
        LOGGER.info("Delete transaction{}", id);

        transactionRepository.deleteById(id);

    }

}


