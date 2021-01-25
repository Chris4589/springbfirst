package com.example.semana02.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserClass implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4235853428728412627L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String lastname;

    //hacer gets y sets

    public UserClass(){}
    public UserClass(String name, String lastname){
        this.lastname = lastname;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }
    public void setLastname(String name) {
        this.lastname = name;
    }
}
