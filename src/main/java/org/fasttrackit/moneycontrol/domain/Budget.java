package org.fasttrackit.moneycontrol.domain;

import org.fasttrackit.moneycontrol.service.BudgetService;
import org.fasttrackit.moneycontrol.transfer.transaction.AddTransactionRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Budget {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    private double balance;

    @NotNull
    private String valuteName;

//
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)


    private Set<Transaction> transactions = new HashSet<>();

   // public void addTransaction(Transaction transaction) {
        //transactions.add(transaction);

       // transaction.getBudget().add(this);
   //}

//    public void removeTransaction(Transaction transaction) {
//        transactions.remove(transaction);
//        transaction.getBudget().remove(this);
//    }



    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Budget budget = (Budget) o;

        return id == budget.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}

