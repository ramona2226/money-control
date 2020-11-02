package org.fasttrackit.moneycontrol.transfer.budget;

public class BudgetResponse {

    long id;

    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
                "type='" + type + '\'' +
                '}';
    }

}
