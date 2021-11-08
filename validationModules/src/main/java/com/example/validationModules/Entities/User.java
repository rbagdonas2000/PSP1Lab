package com.example.validationModules.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;

    public User() {}

    public User(String name, String surname, String phoneNumber, String email, String address, String password) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User with ID: " + id + ", " + name + " " + surname + ", phone number: " + phoneNumber + ", email: " + email +
                ", address: " + address + ", password: " + password;
    }
}
