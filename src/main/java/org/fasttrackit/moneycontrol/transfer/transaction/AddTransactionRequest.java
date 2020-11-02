package org.fasttrackit.moneycontrol.transfer.transaction;

import javax.validation.constraints.NotNull;


public class AddTransactionRequest {


    @NotNull

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AddTrasactionRequest{" +
                "userId=" + userId +

                '}';
    }

}
