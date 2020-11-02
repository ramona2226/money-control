package org.fasttrackit.moneycontrol.service;


import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.TransactionRepository;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;




@Service

public class TransactionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(SaveBudgetRequest request) {
        LOGGER.info("Creating Transaction: {}", request);
        final double totallimitDailyPayment = 100;

        Transaction transaction = new Transaction();

        double overagePayment = transaction.getAmount() - totallimitDailyPayment;


        if (transaction.getType() == "payment" && transaction.getAmount() > totallimitDailyPayment)
            LOGGER.info(" This payment is overage the total daily payment limit with" + overagePayment + " " +
                    "Are you sure you want to make this payment?");
        LOGGER.info("Please press Y for Yes or N for No.");
        if (request.getAnswer() == "Y") {
            LOGGER.info("Succesfull payment");


        } else {
            LOGGER.info("Cancelated transaction");


            if (transaction.getType() == "add") {
                LOGGER.info("Today it`s a happy day! You recive some money.");
            }


// stiu ca  o sa razi  la faza asta dar
            // la income money as dorii daca se poate  sa trimit catre cine mi-a transferat banii  un mesaj de genu
            //  LOGGER.info(" Thank you for your payment, next time, please try to put as many as possible.")
            //   if (transaction.getFrom() isequal(transaction.getFrom()) {
            //  LOGGER.info(" Thank you for your payment, next time, please try to put as many as possible.");
            //  }
            // aici ar trebuii sa cer celui care trimite  o adresa de mail unde sa ii trimita mesajul inapoi, sau un numar de telefon asai?
            // e ceva mai complex si mai complicat aici dar cred ca e bine ca  macar am ideea. desii nu is instare sa scriu o metode
            //update la clasa BugdetService


            transactionRepository.save(transaction);


        }
        return transaction;
    }

    public Transaction getTransaction(long id) {
        LOGGER.info("Retrieving transaction{}", id);


        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Budget" + id + "does not exist"));
       return transaction;
    }


    public void deleteTransaction(long id) {
        LOGGER.info("Delete transaction{}", id);

        transactionRepository.deleteById(id);

    }

}


