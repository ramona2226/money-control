package org.fasttrackit.moneycontrol.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

@NotNull
    // type can be pay  money or add money.
    private String type;

@NotNull
    private double amount;


@NotNull
private LocalDate date;




}
