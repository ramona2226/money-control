package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.domain.Transaction;
import org.fasttrackit.moneycontrol.exception.ResourceNotFoundException;
import org.fasttrackit.moneycontrol.persistance.TransactionRepository;
import org.fasttrackit.moneycontrol.transfer.budget.SaveBudgetRequest;
import org.fasttrackit.moneycontrol.transfer.transaction.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {


    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public final TransactionRepository transactionRepository;
    public final Budget budget;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, BudgetService budgetService, Budget budget) {
        this.transactionRepository = transactionRepository;

        this.budget = budget;
    }

    @Transactional
    public TransactionResponse createTransaction(SaveBudgetRequest request) {
        LOGGER.info("Creating Transaction: {}", request);
        final double totallimitDailyPayment = 100;

        Transaction transaction = new Transaction();

        double overagePayment = transaction.getAmount() - totallimitDailyPayment;


        if (transaction.getType() == "payment" && transaction.getAmount() > totallimitDailyPayment)
            LOGGER.info(" This payment is overage the total daily payment limit with" + overagePayment + " " +
                    "Are you sure you want to make this payment?");
        LOGGER.info("Please press Y for Yes or N for No.");
        if (request.getAnswer() != "Y" && request.getAnswer() != "N") {
            LOGGER.info("Please enter a valid answer");
        } else if (request.getAnswer() == "Y") {
            LOGGER.info("Succesfull payment");
        } else {
            LOGGER.info("Cancelated transaction");


            if (transaction.getType() == "add") {
                LOGGER.info("Today it`s a happy day! You recive some money.");
            } else if (transaction.getType() == "payment" && budget.getBalance() == 0) {
                LOGGER.info("Unsuccesfull transaction. You dont`t have enough money to make a payment.");


                // stiu ca  o sa razi  la faza asta dar..
// la transaction.getType() == "add" y as dorii daca se poate  sa trimit catre cine mi-a transferat banii  un mesaj de genu
//  LOGGER.info(" Thank you for your payment, next time, please try to put as many as possible.")
//   if (transaction.getFrom() isequal(transaction.getFrom()) {
// aici ar trebuii sa cer celui care trimite bani cand face transactia sa ii tr un request si de la
// o adresa de mail unde sa ii trimita mesajul inapoi, sau un numar de telefon ..
// e ceva mult mai complex si mai complicat aici dar pe viitor as dorii sa incerc sa o rezolv .
//  desii eu  nu is in stare sa scriu o metoda de update la clasa BugdetService dar am idei marete :))


// oare aici e de inteles ca doar transactia facuta se salveaza nu si cea eronata asai?
               Transaction saveTransaction = transactionRepository.save(transaction);

               TransactionResponse transactionResponse = new TransactionResponse();
               transactionResponse.setId(saveTransaction.getId());
                transactionResponse.setType(saveTransaction.getType());
                transactionResponse.setFrom(saveTransaction.getFrom());
               transactionResponse.setTo(saveTransaction.getTo());
                transactionResponse.setAmount(saveTransaction.getAmount());
                transactionResponse.setDate(saveTransaction.getDate());
                transactionResponse.setDescription(saveTransaction.getDescription());

            }


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

// de aici in jos nu stiu daca sa citesti sau nu dar am avut ganduri la 3 noapte
// asa ca le-am pus aici. o sa le sterg dupa ce o sa salvez o varianta cu ele .


//           // int month = 0;
//            //double expectedSpentmoneyUseingLimitOverage;
//          //  double moneyToSave;
//            //double totalIncomeMoneyPerMonth;
//          //  double totalSpentMoneyThisMont;
//
//            //trebuie sa sortez toate transactiile de pe o luna, sortand dupa data transactie
//                // if (transaction.getType() == "add" && transaction.getDate(). ar fi din prima zi a lunei pana in ultima zi
//
//        // if (double expectedSpendMoneyUseingLimitOverage == totalSpentMoneyThisMonth &&
//        totalIncomeMoneyPerMonth > totalSpentMoneyThisMonth) {
//       fac o metoda si ii dau return transaction si un savetransaction cv de genu ma gandesc.
//  public Transaction sendMoneyToSavingMoney(double totalIncomeMoneyPerMonth, double expectedSpentMoneyUserinLimitOverage) {
// moneyToSave ==  totalIncomeMoneyPerMonth - totalSpentMoneyThisMont
//
//
//        //    LOGGER.info("Please Enter Month Number from 1 to 12 (1 = Jan, and 12 = Dec) :");
//
//        //    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
//        //    {   expectedSpentmoneyUseingLimitOverage =  31 * totallimitDailyPayment;
//
//          //  }
//            //else if ( month == 4 || month == 6 || month == 9 || month == 11 )
//            //{
//              //  expectedSpentmoneyUseingLimitOverage =  30 * totallimitDailyPayment;
//                //moneyToSave = expectedSpentmoneyUseingLimitOverage;
//            //}
//            //else if ( month == 2 )
//            //{
//              //  expectedSpentmoneyUseingLimitOverage =  28 * totallimitDailyPayment;
//                //moneyToSave = expectedSpentmoneyUseingLimitOverage;
//            //}
//            //else if (month == 0 && month >12) {
//
//            //}
//
//              //  LOGGER.info(" Please enter Valid Number between 1 to 12.");
//






