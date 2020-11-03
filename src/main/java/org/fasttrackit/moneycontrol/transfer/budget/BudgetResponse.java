package org.fasttrackit.moneycontrol.transfer.budget;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class BudgetResponse {

    @NotNull
     private long Id;
private Set<TransactionInBudget> transactions ;
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

    public void setTransactions(Set<TransactionInBudget> transactions) {
        this.transactions = transactions;
    }

    public Set<TransactionInBudget> getTransactions() {
        return transactions;
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
                "Id=" + Id +
                ", transactions=" + transactions +
                ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
