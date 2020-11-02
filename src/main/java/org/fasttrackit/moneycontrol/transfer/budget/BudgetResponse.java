package org.fasttrackit.moneycontrol.transfer.budget;

import javax.validation.constraints.NotNull;

public class BudgetResponse {

    @NotNull
     private long Id;

    @NotNull
    double balance;

    @NotNull
    String valuteName;

private String answer;

    public long getId() {
        return Id;
    }

    public void setId(long userId) {
        this.Id = userId;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "BudgetResponse{" +
                "userId=" + Id +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
