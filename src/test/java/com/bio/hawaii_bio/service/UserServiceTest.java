package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.UserRequest;
import com.bio.hawaii_bio.dto.UserResponse;
import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class UserServiceTest {

    @Autowired
    UserRepo userRepo;

    UserService userService;

    @BeforeEach
    public void setUp(){
        User adm = new User("adm", "adm@mail.com", "1234");
        adm.addRole(Role.ADMIN);
        User mem = new User("mem", "mem@mail.com", "1234");
        mem.addRole(Role.USER);

        userRepo.save(adm);
        userRepo.save(mem);
        userService = new UserService();
    }

    @Test
    void getUsers() {
        List<UserResponse> users = userService.getUsers();
        assertEquals(2, users.size());
        assertInstanceOf(UserResponse.class, users.get(0));
    }

    @Test
    void getUser() {
        User mem = new User("mem", "mem@mail.com",
                "1234");
        UserResponse userResOne = new UserResponse(mem);
        UserResponse userResTwo = userService.getUser("mem");
        assertEquals(userResOne.getUsername(), userResTwo.getUsername());
    }

    @Test
    void addUser() {
        UserRequest memTwo = new UserRequest("mem2", "mem2@mail.com", "1234");
        userService.addUser(memTwo);
        List<UserResponse> users = userService.getUsers();
        assertEquals(5, users.size());
        assertEquals("mem2@mail.com", userService.getUser("mem2").getEmail());
    }

    @Test
    void editUser() {
        String newEmail = "adm2@mail.com";

        UserRequest adm2 = new UserRequest( "adm2","a2@mail.com",
                "1234");

        assertEquals(userService.getUser("adm2").getEmail(), "a2@mail.com");

        adm2.setEmail(newEmail);
        UserResponse userToEdit = userService.editUser(adm2, "adm2");
        assertEquals(userToEdit.getEmail(), newEmail);

    }

    @Test
    void deleteUser() {
        assertEquals(userService.getUser("mem").getEmail(), "mem@mail.com");
        assertEquals(2, userService.getUsers().size());

        userService.deleteUser("mem");

        assertEquals(1, userService.getUsers().size());
        assertThrows(Client4xxException.class, () -> userService.getUser("mem"));
    }
}