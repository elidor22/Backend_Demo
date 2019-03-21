package com.Backend_Aplication_Start.Backend_Demo;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {


    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    //The empty constructor is called by default by Spring and without it the program just fails to be loaded at all
    public User (){

    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
