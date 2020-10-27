package org.fasttrackit.moneycontrol.transfer;

import org.fasttrackit.moneycontrol.domain.Budget;

import java.time.LocalDate;

public class IncomeTransaction extends Budget {

    private String from;
    //asta ar fi to.  ca din moment ce la mine in cont apar inseamna ca eu i-am primit
    // id nu cred mai trebuie sa pun din moment ce am pus ca incomeTransaction extinde clasa Budget
   // private Long userId;
    private LocalDate date;
    private String description;


// aici poate apuc sa adaug complexitate sa pun sa aleaga valuta in care sa transfere banii sa fie gen, eurp, ron, GBP, vedem  daca am timp.
// aici pe partea de front end m-am gandit sa fac doar un tabel sa mi le afiseze .
    // ce parere ai?

}
