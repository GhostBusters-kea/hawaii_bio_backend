package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    int phoneNumber;
    String username;
    String password;
    String firstName;
    String lastName;
    String email;
    String address;
    String city;
    int zip;
    Role role;
    boolean isAdmin;

    public UserRequest(int phoneNumber, String username, String password, String firstName, String lastName, String email, String address, String city, int zip, Role role) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.role = role;
    }

    public UserRequest(int phoneNumber, String username, String password, String firstName, String lastName, String email, Role role) {
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    public UserRequest(int phoneNumber, Role role) {
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}


