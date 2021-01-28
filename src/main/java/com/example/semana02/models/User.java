package com.example.semana02.models;

import java.io.Serializable;
//ejecutar keycloack para que jale 
public class User implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 5701619718664391264L;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    } 

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}