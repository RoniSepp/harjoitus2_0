package org.roniseppala.harjoitus2_0;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    protected static final long serialVersionUID = 4178614861L;

    public User(String firstName, String lastName, String email, String ala){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = ala;
    }

    public String getFirstNameName(){
        return (this.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail(){
        return (this.email);
    }

    public String getDegreeProgram(){
        return (this.degreeProgram);
    }



}
