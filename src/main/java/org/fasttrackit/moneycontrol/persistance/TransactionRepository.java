
package org.fasttrackit.moneycontrol.persistance;


import org.fasttrackit.moneycontrol.domain.Transaction;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {



}

