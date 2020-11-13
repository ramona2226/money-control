package org.fasttrackit.moneycontrol.transfer.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SaveUserRequest {

    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid user name")
    @NotNull
    private String firstName;
    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid user name")
    @NotNull
    private String lastName;

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
        return "CreateUserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
