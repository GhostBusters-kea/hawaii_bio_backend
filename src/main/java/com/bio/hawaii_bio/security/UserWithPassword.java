package com.bio.hawaii_bio.security;

import com.bio.hawaii_bio.entity.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserWithPassword {
    PasswordEncoder pwEncoder = new BCryptPasswordEncoder();

    void setPassword(String password);

    Role getRole();

    String getUsername();

    String getEmail();

    String getPassword();

    static PasswordEncoder getPasswordEncoder(){
        return pwEncoder;
    }
}
