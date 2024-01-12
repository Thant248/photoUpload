package com.example.fileupload.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data

public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String message;

    public Greeting(){}

    public Greeting(String message){
        this.message  = message;
    }
    
}
