package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo){this.userRepo = userRepo;}

    public UserResponse addUser(UserRequest body) {
        if(userRepo.existsByUsername(body.getUsername())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username is already taken");
        }
        if(userRepo.existsByEmail(body.getEmail())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Email is used by another User");
        }

        User user = new User(body);
        // All new users are by default given the role USER
        user.addRole(Role.USER);
        userRepo.save(user);
        return new UserResponse(user);
    }

    public List<UserResponse> getUsers() {
        List<User> users = userRepo.findAll();
        return UserResponse.getUsersFromEntities(users);
    }

    public UserResponse getUser(String id) {
        User user = userRepo.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User with id '"+id+"' not found"));
        return new UserResponse(user);
    }

    public UserResponse editUser(UserRequest body, String id) {
        User user = userRepo.findById(id).orElseThrow();
        return new UserResponse(userRepo.save(user));
    }

    public void deleteUser(String id) {
        User User = userRepo.findById(id).orElseThrow();
        userRepo.delete(User);
    }
}
