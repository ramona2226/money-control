package org.fasttrackit.moneycontrol.persistance;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BudgetRepository extends JpaRepository<Budget, Long> {

  // @Query(value = "Select * FROM Budget  budget Where (:partialId IS_NOT_NULL)");




}