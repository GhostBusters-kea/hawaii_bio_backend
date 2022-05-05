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
}
