package org.fasttrackit.moneycontrol.transfer;

import javax.validation.constraints.NotNull;

public class SaveBudgetRequest {


    @NotNull
    private double mybudget;

    @NotNull
    private String valuteName;

    public double getMybudget() {
        return mybudget;
    }

    public void setMybudget(double mybudget) {
        this.mybudget = mybudget;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    @Override
    public String toString() {
        return "SaveBudgetRequest{" +
                "mybudget=" + mybudget +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }
}





