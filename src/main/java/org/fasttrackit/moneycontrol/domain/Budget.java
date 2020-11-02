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

// un budget poate sa aiba mai multe transactii
//aceasi transactie poate sa existe in mai multe bugete;
// DE EX un abonament la Netflix poate sa aiba aceasi transactie de la mai multi clienti.


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "budget_transaction",
    joinColumns = @JoinColumn(name = "budget_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id"))

    private Set<Transaction> transactions = new HashSet<>();


    private double balance;

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
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}

