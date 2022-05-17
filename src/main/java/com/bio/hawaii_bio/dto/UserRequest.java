package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.security.UserWithPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UserRequest {


    @NotBlank
    @Size(min = UserWithPassword.USER_NAME_MIN_SIZE, max = UserWithPassword.USER_NAME_MAX_SIZE)
    private String username;

    @NotBlank
    @Size(max = UserWithPassword.EMAIL_MAX_SIZE)
    @Email
    private String email;

    @NotBlank
    @Size(min = UserWithPassword.PASSWORD_MIN_SIZE, max = UserWithPassword.PASSWORD_MAX_SIZE)
    private String password;
}