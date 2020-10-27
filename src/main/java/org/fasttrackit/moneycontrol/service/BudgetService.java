package org.fasttrackit.moneycontrol.service;

import org.fasttrackit.moneycontrol.domain.Budget;
import org.fasttrackit.moneycontrol.persistance.BudgetRepository;
import org.fasttrackit.moneycontrol.transfer.SaveBudgetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BudgetService {

   private static final Logger LOGGER = LoggerFactory.getLogger(BudgetService.class);

   // trebuie sa ii fac si un inversion of Control?
   public final BudgetRepository budgetRepository;


   @Autowired
   public BudgetService(BudgetRepository budgetRepository) {
      this.budgetRepository = budgetRepository;
   }


   public Budget createBudget(SaveBudgetRequest request) {
      Budget mybudget = new Budget();
      mybudget.setAvailableBalance(request.getMybudget());
      mybudget.setValuteName(request.getValuteName());

// o sa implementez  sa fie interfetele crudRepository si sa dau adnnotarea @NoRepositoryBean dar nu mai stiu
      // exact cum asa ca o sa caut pe video
   return BudgetRepository.save(mybudget);

}

// o sa creez si metoda read, and detele si apoi da le adaug in test.


public double updateBuget(long id, double availableBudget, double incomeMoney ) {


   double newBudget = availableBudget + incomeMoney;


    return newBudget;
}
}
// aici am facut o metoda de update in care  primeste parametrul valoarea de adunat la bugetul existent,
//dar cred ca imi trebuie si un update ca atunci cand fac payment. o  operatie de scadere. si ma gandesc sa
// adaoug oare in metoda creata mai sus si parametrul double payment si sa  pun o conditie ca daca sa adauga bani
// sa se faca operatia de adunare, iar daca se face plata sa se execute operatia de scadere.

