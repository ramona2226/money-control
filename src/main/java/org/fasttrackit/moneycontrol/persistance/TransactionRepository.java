package org.fasttrackit.moneycontrol.persistance;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static org.hibernate.hql.internal.antlr.SqlTokenTypes.FROM;


public interface TransactionRepository extends JpaRepository<Budget, Long> {


   // @Query(value = "Select * FROM Transaction transaction Where id IS_NOT_NULL");

}
