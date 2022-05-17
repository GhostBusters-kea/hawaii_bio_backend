package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/persons")
public class UserController {

    UserService userService;

    public UserController(UserService personService) {
        this.userService = personService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> addPerson(@RequestBody @Valid UserRequest body) {
        return ResponseEntity.ok(userService.addUser(body));
    }

    @GetMapping
    public List<UserResponse> getPersons(){
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public UserResponse getPerson(@PathVariable String username)  {
        return userService.getUser(username);
    }

    @PutMapping("/{username}")
    public UserResponse editPerson(@RequestBody UserRequest body, @PathVariable String username){
        return userService.editUser(body, username);
    }

    @DeleteMapping("/{username}")
    public void deletePerson(@PathVariable String username){
        userService.deleteUser(username);
    }
}
