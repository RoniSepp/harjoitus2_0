package org.roniseppala.harjoitus2_0;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private Boolean isKandi;
    private Boolean isDI;
    private Boolean isTohtori;
    private Boolean isUima;

    protected static final long serialVersionUID = 4178614861L;

    public User(String firstName, String lastName, String email, String ala, Boolean kandi, Boolean di, Boolean tohtori, Boolean uima){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = ala;
        this.isKandi = kandi;
        this.isDI = di;
        this.isTohtori = tohtori;
        this.isUima = uima;
    }

    public Boolean getKandi() {
        return isKandi;
    }

    public Boolean getDI() {
        return isDI;
    }

    public Boolean getTohtori() {
        return isTohtori;
    }

    public Boolean getUima() {
        return isUima;
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
