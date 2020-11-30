package org.fasttrackit.moneycontrol.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
//@Table(uniqueConstraints = {@UniqueConstraint(name= "firstName_lastName_unique_key",
//@Column (name = "first_name"), @Column(name ="last_name"))});



public class User {

    @Id
    @GeneratedValue
    private long id;


    @NotNull
    private String firstName;


    @NotNull
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


   // public void setBudget(double balance, String valuteName) {
  //  }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
