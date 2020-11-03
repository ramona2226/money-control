package org.fasttrackit.moneycontrol.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Budget{

    @Id

    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    private double balance;

// un budget poate sa aiba mai multe transactii
//aceasi transactie poate sa existe in mai multe bugete;
// DE EX un abonament la Netflix poate sa aiba aceasi transactie de la mai multi clienti.


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "budget_transaction",
    joinColumns = @JoinColumn(name = "budget_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private Set<Transaction> transactions = new HashSet<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

transaction.getBudget().add(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.getBudget().remove(this);
    }

@NotNull
    private  String valuteName;

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public double getExistingAvailableBalance() {
        return balance;
    }

    public void setExistingAvailableBalance(double existingAvailableBalance) {
        this.balance = existingAvailableBalance;
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

