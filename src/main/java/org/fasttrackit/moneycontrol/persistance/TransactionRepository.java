
package org.fasttrackit.moneycontrol.persistance;


import org.fasttrackit.moneycontrol.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT transaction FROM Transaction transaction" +
            " Where transaction.user.id=:userId")
    Page<Transaction> findAllByuserId(long userId, Pageable pageable);

}

