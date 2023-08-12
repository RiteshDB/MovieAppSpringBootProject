package com.upgrad.MovieApp.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    @Column(name="first_name", length = 20, nullable = false)
    private String firstName;
    @Column(name="last_name", length = 20, nullable = false)
    private String lastName;
    @Column(name="user_name", length = 20, nullable = false, unique = true)
    private String userName;
    @Column(name= "password", nullable = false )
    private String password;
    @Column(name= "DOB", nullable = false)
    private LocalDateTime dateOfBirth;
}
