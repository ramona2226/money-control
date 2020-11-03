package org.fasttrackit.moneycontrol.transfer.transaction;

import java.time.LocalDate;

public class GetTransactionsRequest {

    private String type;
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return LocalDate.parse(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GetTransactionsRequest{" +
                "type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}