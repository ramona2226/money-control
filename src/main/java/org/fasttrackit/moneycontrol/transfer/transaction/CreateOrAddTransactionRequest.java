package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateOrAddTransactionRequest {


    @NotNull

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NotNull
    private long type;

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
        private LocalDate date;

    @NotNull
    private String description;


    public long getType() {
        return type;
    }

    public void setType(long type) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return "AddTrasactionRequest{" +
                "userId=" + userId +
                ", type=" + type +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

}
