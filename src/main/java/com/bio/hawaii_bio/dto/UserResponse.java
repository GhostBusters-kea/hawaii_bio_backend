package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    protected int phoneNumber;
    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
    protected String city;
    protected int zip;


    protected String roleName;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    protected LocalDateTime creationTime;
    @UpdateTimestamp
    protected LocalDateTime edited;

    public UserResponse(int phoneNumber, Role roleName, LocalDateTime creationTime) {
        this.phoneNumber = phoneNumber;
        this.roleName = roleName.toString();
        this.creationTime = creationTime;
    }

    public UserResponse(User user, Role role) {
        switch (role) {
            case CUSTOMER:
                this.phoneNumber = user.getPhoneNumber();
            case MEMBER:
                this.phoneNumber = user.getPhoneNumber();
                this.username = user.getUsername();
                this.firstName = user.getFirstName();
                this.lastName = user.getLastName();
                this.email = user.getEmail();
            case EMPLOYEE:
                this.phoneNumber = user.getPhoneNumber();
                this.username = user.getUsername();
                this.firstName = user.getFirstName();
                this.lastName = user.getLastName();
                this.email = user.getEmail();
                this.address = user.getAddress();
                this.city = user.getCity();
                this.zip = user.getZip();
            case ADMIN:
                this.phoneNumber = user.getPhoneNumber();
                this.username = user.getUsername();
                this.firstName = user.getFirstName();
                this.lastName = user.getLastName();
                this.email = user.getEmail();
                this.address = user.getAddress();
                this.city = user.getCity();
                this.zip = user.getZip();
        }
    }
}
