package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    String username;
    String email;
    List<String> roleNames;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.roleNames = user.getRoles().stream().map(role -> role.toString()).collect(Collectors.toList());
        this.email = user.getEmail();
    }

    public static List<UserResponse> getUsersFromEntities(List<User> persons) {
        return persons.stream().map(UserResponse::new).collect(Collectors.toList());
    }
}

