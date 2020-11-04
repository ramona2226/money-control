package org.fasttrackit.moneycontrol.transfer.transaction;

import java.time.LocalDate;

public class GetTransactionsRequest {

    private String date;

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GetTransactionsRequest{" +
                ", date='" + date + '\'' +
                '}';
    }
}