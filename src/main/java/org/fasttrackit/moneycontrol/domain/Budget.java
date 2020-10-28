package org.fasttrackit.moneycontrol.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Budget {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @MapsId
    private User user;


    private double existingAvailableBalance;

@NotNull
    private  String valuteName;



    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }


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

    public double getAvailableBalance() {
        return existingAvailableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.existingAvailableBalance = availableBalance;
    }


    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", user=" + user +
                ", valuteName='" + valuteName + '\'' +
                ", availableBalance=" + existingAvailableBalance +
                '}';
    }
}

