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

    private Long id;

    // aici NU imi trebuie asai un private long transactionId pt ca  clasa transaction are acelasi  care coicide
    // cu cel a userului si a bugetului doar cand fac o noua transactie aia sa primeasca un
    // id. cum am pus in AddTransactionRequest. oare bine am inteles?


    //  aici nu is sigura daca are sens sa creez si eu o clasa producservice in cazul aplicatiei online shopping
    //  ziceai ca o sa avem erori cu hibernate Lazy initionalize  ca in Produc avem relatia aia cu un cart care trebuie tratada cu dto ul ,
    // nu ma intereseaza pt fiecare produc in parte
    @ManyToOne
    @MapsId
    private User user;

    @NotNull
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

    @ManyToMany(mappedBy = "transactions")
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
                ", user=" + user +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

}