package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.security.UserWithPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter @Setter @NoArgsConstructor
@Entity
public class User implements UserWithPassword {

    @Id
    @Column(nullable = false, unique = true, length = 12)
    private int phoneNumber;

    @Column(unique = true, length = 25)
    private String username;

    @Column(length = 25)
    private String firstName;

    @Column(length = 25)
    private String lastName;

    @Column(unique = true, length = 75)
    private String email;

    @Column(length = 72)
    private String password;

    @Column(length = 75)
    private String address;

    @Column(length = 25)
    private String city;

    @Column(length = 4)
    private int zip;

    private boolean isAdmin;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CUSTOMER','MEMBER', 'EMPLOYEE', 'ADMIN')")
    private Role role;

    @CreationTimestamp
    LocalDateTime CreationTime;

    @UpdateTimestamp
    LocalDateTime edited;

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Reservation> reservations = new HashSet<>();

    // Employee and Admin
    public User(int phoneNumber, String username, String firstName, String lastName, String email, String password,
                String address, String city, int zip, Role role) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = pwEncoder.encode(password);
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.role = role;
        if (role == Role.ADMIN){
            this.isAdmin = true;
        }
    }

    // Member
    public User(int phoneNumber, String username, String firstName, String lastName, String email, String password, Role role) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = pwEncoder.encode(password);
        this.role = role;
    }

    // Customer
    public User(int phoneNumber, Role role) {
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User(UserRequest body, Role role) {
        this.role = role;
        switch (role) {
            case CUSTOMER:
                this.phoneNumber = body.getPhoneNumber();
                this.isAdmin = false;
            case MEMBER:
                this.phoneNumber = body.getPhoneNumber();
                this.username = body.getUsername();
                this.firstName = body.getFirstName();
                this.lastName = body.getLastName();
                this.email = body.getEmail();
                this.isAdmin = false;
            case EMPLOYEE:
                this.phoneNumber = body.getPhoneNumber();
                this.username = body.getUsername();
                this.firstName = body.getFirstName();
                this.lastName = body.getLastName();
                this.email = body.getEmail();
                this.address = body.getAddress();
                this.city = body.getCity();
                this.zip = body.getZip();
                this.isAdmin = false;
            case ADMIN:
                this.phoneNumber = body.getPhoneNumber();
                this.username = body.getUsername();
                this.firstName = body.getFirstName();
                this.lastName = body.getLastName();
                this.email = body.getEmail();
                this.address = body.getAddress();
                this.city = body.getCity();
                this.zip = body.getZip();
                this.isAdmin = true;
        }
    }

    @Override
    public void setPassword(String password) {
        this.password = pwEncoder.encode(password);
    }

    @Override
    public Role getRole() {
        return role;
    }
}
