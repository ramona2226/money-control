package org.fasttrackit.moneycontrol.transfer.budget;

public class BudgetResponse {

    long id;

    double balance;

    String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BudgetResponse{" +
                "id=" + id +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                '}';
    }
}
