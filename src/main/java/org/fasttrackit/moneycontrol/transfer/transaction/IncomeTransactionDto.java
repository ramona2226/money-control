package org.fasttrackit.moneycontrol.transfer.transaction;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class IncomeTransactionDto {
    @NotNull
    private String from;
@NotNull
  private Long userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
