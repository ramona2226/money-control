package org.fasttrackit.moneycontrol.transfer.budget;

import javax.validation.constraints.NotNull;

public class SaveBudgetRequest {


    @NotNull
    private double balance;

    @NotNull
    private String valuteName;

    private String answer;

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
        return "SaveBudgetRequest{" +
                "balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}







