package com.bio.hawaii_bio.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(nullable = false, unique = true, length = 12)
    private int phoneNumber;

    @Column(unique = true, length = 25)
    private String username;

    @Column(unique = true, length = 75)
    private String email;

    @Column(length = 72)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CUSTOMER','MEMBER','ADMIN')")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_role")
    List<Role> roles = new ArrayList<>();


    public User(String username, String email, String password) {

        this.username = username;
        this.email = email;
        this.password = bCrypt.encode(password);

    }

    @Override
    public void setPassword(String password) {
        this.password = bC.encode(password);
    }

    @Override
    public List<Role> getRoles() {
        return roles;
    }

}
