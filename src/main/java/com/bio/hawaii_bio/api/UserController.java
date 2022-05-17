package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody @Valid UserRequest body) {
        return ResponseEntity.ok(userService.addUser(body));
    }

    @GetMapping
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public UserResponse getUser(@PathVariable String username)  {
        return userService.getUser(username);
    }

    @PutMapping("/{username}")
    public UserResponse editUser(@RequestBody UserRequest body, @PathVariable String username){
        return userService.editUser(body, username);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}
