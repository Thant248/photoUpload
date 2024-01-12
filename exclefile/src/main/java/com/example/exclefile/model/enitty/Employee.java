package com.example.exclefile.model.enitty;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    private int id;
    
    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String gender;

    private String address;

    private String goal;
    
    public Employee(){}

    public Employee(String firstName, String lastName, int age, String email, String gender, String address, String goal){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.goal = goal;
    }
}
