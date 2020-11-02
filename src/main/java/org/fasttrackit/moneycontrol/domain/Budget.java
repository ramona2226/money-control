package org.fasttrackit.moneycontrol.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Budget{

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


    private double balance;

@NotNull
    private  String valuteName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getExistingAvailableBalance() {
        return balance;
    }

    public void setExistingAvailableBalance(double existingAvailableBalance) {
        this.balance = existingAvailableBalance;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", user=" + user +
                ", existingAvailableBalance=" + balance +
                ", valuteName='" + valuteName + '\'' +
                '}';
    }


}

