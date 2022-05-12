package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo){ this.userRepo = userRepo; }

    public List<UserResponse> getUsers(){
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> new UserResponse(user, user.getRole())).collect(Collectors.toList());
    }

    public UserResponse getUser(int phoneNumber){
        User user = userRepo.findById(phoneNumber).orElseThrow(() -> new Client4xxException("User not found", HttpStatus.NOT_FOUND));
        return new UserResponse(user, user.getRole());
    }

    public UserResponse addUser(UserRequest body, Role role){
        if(userRepo.existsById(body.getPhoneNumber())){
            throw new Client4xxException(("User already exists"));
        }
        if(userRepo.emailExist(body.getEmail())){
            throw new Client4xxException("An account with that email already exists");
        }
        User UserNew = new User(body, role);
        UserNew = userRepo.save(UserNew);

        return new UserResponse(UserNew.getPhoneNumber(), UserNew.getRole(), UserNew.getCreationTime());
    }

    public UserResponse editUser(UserRequest body, int phoneNumber){
        if(!(userRepo.existsById(body.getPhoneNumber()))){
            throw new Client4xxException("No Such User exists");
        }
        User UserToEdit = new User(body, body.getRole());
        UserToEdit.setPhoneNumber(phoneNumber);
        userRepo.save(UserToEdit);
        return new UserResponse(UserToEdit, UserToEdit.getRole());
    }

    public void deleteUser(int phoneNumber){
        if(!(userRepo.existsById(phoneNumber))){
            throw new Client4xxException("No Such User exists");
        }
        userRepo.deleteById(phoneNumber);
    }
}
