package org.fasttrackit.moneycontrol.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name= "firstName_lastName_unique_key",
        columnNames = {"first_name", "last_name"})})



public class User {

    @Id
    @GeneratedValue
    private long id;


    @NotNull
    @Column(name = "first_name")
    private String firstName;


    @NotNull
    @Column(name = "last_name")
    private String lastName;



    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
