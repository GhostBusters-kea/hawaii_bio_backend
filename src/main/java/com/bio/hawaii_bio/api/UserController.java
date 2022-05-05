package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getMembers(){return userService.getUsers();}

    @GetMapping("/{phoneNumber}")
    public UserResponse getMember(@PathVariable int phoneNumber){
        return userService.getUser(phoneNumber);
    }

    @PostMapping
    public UserResponse addMember(@RequestBody UserRequest body, Role role){
        return userService.addUser(body, role);
    }

    @PutMapping("/{phoneNumber}")
    public UserResponse editMember(@RequestBody UserRequest body, @PathVariable int phoneNumber){

        return userService.editUser(body, phoneNumber);
    }

    @DeleteMapping("/{phoneNumber}")
    public void deleteMember(@PathVariable int phoneNumber){
        userService.deleteUser(phoneNumber);
    }
}
