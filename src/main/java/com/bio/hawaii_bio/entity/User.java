package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.security.UserWithPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class User implements UserWithPassword {

    @Id
    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 72)
    private String password;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('USER','ADMIN')")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="security_role")
    List<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();

    @Override
    public void addRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public void setPassword(String password) {
        this.password = pwEncoder.encode(password);
    }


    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = pwEncoder.encode(password);;
        this.enabled = true;
    }

    public User(UserRequest body) {
        this.username = body.getUsername();
        this.email = body.getEmail();
        this.password = pwEncoder.encode(body.getPassword());
        this.enabled = true;
    }

    public boolean isEnabled() { return this.enabled; }
}