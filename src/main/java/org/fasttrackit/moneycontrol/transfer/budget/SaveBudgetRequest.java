package org.fasttrackit.moneycontrol.transfer.budget;

import javax.validation.constraints.NotNull;

public class SaveBudgetRequest {

    @NotNull
    private long id;

    @NotNull
    private double balance;

    @NotNull
    private String valuteName;


    private String answer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "SaveBudgetRequest{" +
                "id=" + id +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}