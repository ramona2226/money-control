package org.fasttrackit.moneycontrol.transfer.budget;


public class BudgetResponse {


    private long Id;

    private double balance;

    private String valuteName;


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


    @Override
    public String toString() {
        return "BudgetResponse{" +
                "Id=" + Id +
                 ", balance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}
