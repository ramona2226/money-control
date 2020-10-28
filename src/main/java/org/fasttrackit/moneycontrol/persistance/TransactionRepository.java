package org.fasttrackit.moneycontrol.persistance;


import org.fasttrackit.moneycontrol.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TransactionRepository extends JpaRepository<Transaction, Long> {


   // @Query(value = "Select * FROM Transaction transaction Where id IS_NOT_NULL");

}
