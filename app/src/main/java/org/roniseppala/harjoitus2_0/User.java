package org.roniseppala.harjoitus2_0;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

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
