package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class AddTransactionRequest {


    @NotNull
   private Long userId;

   @NotNull
   private Long transactionId;

    @NotNull
    private String type;

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

    private Double userBalance;

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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
                ", transactionId=" + transactionId +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", userBalance=" + userBalance +
                '}';
    }
}
