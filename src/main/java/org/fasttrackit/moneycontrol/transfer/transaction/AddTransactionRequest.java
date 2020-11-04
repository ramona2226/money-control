package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class AddTransactionRequest {

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
    private double amount;

    @NotNull
    private LocalDate date;

    @NotNull
    private String description;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AddTransactionRequest{" +
              //  "userId=" + userId +
                //", transactionId=" + transactionId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                //", userBalance=" + userBalance +
                '}';
    }
}
