package org.fasttrackit.moneycontrol.transfer.budget;

import javax.validation.constraints.NotNull;

public class BudgetResponse {

    @NotNull
     private long userId;
@NotNull
    double balance;
@NotNull
    String valuteName;

private String answer;

    public long getId() {
        return userId;
    }

    public void setId(long id) {
        this.userId = id;
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
    public String toString() {
        return "BudgetResponse{" +
                "id=" + userId +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}
