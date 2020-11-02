package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class AddTransactionRequest {


    @NotNull
    long userId;

    @NotNull
    // type can be pay  money or add money.
    private String type;

    @NotNull
    private String from;

    @NotNull
    private String to;

    private double amount;

    @NotNull
    private LocalDate date;

    @NotNull
    private String description;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
                "userId=" + userId +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
