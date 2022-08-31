package com.example.projectx.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "password")
    @NonNull
    private String password;


    public Customer() {
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
