package org.fasttrackit.moneycontrol.domain;

import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Transaction {

    @Id
    private long id;

    @OneToOne
    @MapsId
    private User user;

@NotNull
    // type can be pay  money or add money.
    private String type;

@NotNull
    private double amount;



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
