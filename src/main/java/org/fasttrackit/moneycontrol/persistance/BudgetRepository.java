package org.fasttrackit.moneycontrol.persistance;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BudgetRepository extends JpaRepository<Budget, Long> {

}