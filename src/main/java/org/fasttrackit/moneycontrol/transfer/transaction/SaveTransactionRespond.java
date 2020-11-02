package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class SaveTransactionRespond {

    private String partialType;

    @NotNull
    private String partialFrom;

    @NotNull
    private String partialTo;

    @NotNull
    private double partialAmount;

    @NotNull
    private LocalDate partialDate;

    @NotNull
    private String partialDescription;

    public String getPartialType() {
        return partialType;
    }

    public void setPartialType(String partialType) {
        this.partialType = partialType;
    }

    public String getPartialFrom() {
        return partialFrom;
    }

    public void setPartialFrom(String partialFrom) {
        this.partialFrom = partialFrom;
    }

    public String getPartialTo() {
        return partialTo;
    }

    public void setPartialTo(String partialTo) {
        this.partialTo = partialTo;
    }

    public double getPartialAmount() {
        return partialAmount;
    }

    public void setPartialAmount(double partialAmount) {
        this.partialAmount = partialAmount;
    }

    public LocalDate getPartialDate() {
        return partialDate;
    }

    public void setPartialDate(LocalDate partialDate) {
        this.partialDate = partialDate;
    }

    public String getPartialDescription() {
        return partialDescription;
    }

    public void setPartialDescription(String partialDescription) {
        this.partialDescription = partialDescription;
    }

    @Override
    public String toString() {
        return "SaveTransactionRespond{" +
                "partialType='" + partialType + '\'' +
                ", partialFrom='" + partialFrom + '\'' +
                ", partialTo='" + partialTo + '\'' +
                ", partialAmount=" + partialAmount +
                ", partialDate=" + partialDate +
                ", partialDescription='" + partialDescription + '\'' +
                '}';
    }
}
