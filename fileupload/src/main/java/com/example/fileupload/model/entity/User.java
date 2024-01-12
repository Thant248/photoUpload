package com.example.fileupload.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class User {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

   
    private String email;

    public User(){}


    public User(String firstName, String lastName, String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }
}
