package org.fasttrackit.moneycontrol.transfer.budget;

import org.fasttrackit.moneycontrol.domain.Transaction;

import java.util.Set;

public class BudgetResponse {


    private long Id;

    private Transaction balance;

    private String valuteName;


    public long getId() {
        return Id;
    }

    public void setId(long userId) {
        this.Id = userId;
    }

    public Transaction getBalance() {
        return balance;
    }

    public void setBalance(Transaction balance) {
        this.balance = balance;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }


    @Override
    public String toString() {
        return "BudgetResponse{" +
                "Id=" + Id +
                 ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}
