package org.fasttrackit.moneycontrol.transfer.budget;

public class BudgetResponse {

    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BudgetResponse{" +
                "id=" + id +
                '}';
    }
}
