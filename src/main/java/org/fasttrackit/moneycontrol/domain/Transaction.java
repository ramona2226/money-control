package org.fasttrackit.moneycontrol.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transaction {


    @Id
    @GeneratedValue

    private long id;


  @ManyToOne
    @MapsId
    private User user;

    @NotNull
    // type can be pay  money or add money.
    private String type;

    @NotNull
    private String from;

    @NotNull
    private String to;

    @NotNull
    private Double amount;

    @NotNull
    private LocalDate date;

    @NotNull
    private String description;

    @ManyToMany(mappedBy = "transaction")
    private Set<Budget> budget = new HashSet<>();

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<Budget> getBudget() {
        return budget;
    }

    public void setBudget(Set<Budget> budget) {
        this.budget = budget;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

}