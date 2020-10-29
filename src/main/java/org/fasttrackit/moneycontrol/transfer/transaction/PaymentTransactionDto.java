package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PaymentTransactionDto {


    @Id
    @NotNull
    private Long id;
@NotNull
    private String to;
@NotNull
    private LocalDate date;
@NotNull
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "PaymentTransactionDto{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
