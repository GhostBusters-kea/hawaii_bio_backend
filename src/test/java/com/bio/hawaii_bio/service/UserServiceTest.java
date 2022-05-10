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

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {

    @Autowired
    UserRepo userRepo;

    UserService userService;

    @BeforeEach
    public void setUp(){
        User adm = new User(12345678, "adm", "a", "aa", "a@mail.com",
                "1234", "street", "city", 2000, Role.ADMIN);
        User emp = new User(23456789, "emp", "b", "bb", "b@mail.com",
                "1234", "street", "city", 2000, Role.EMPLOYEE);
        User mem = new User(34567891, "mem", "c", "cc", "c@mail.com",
                "1234", Role.MEMBER);
        User cus = new User(45678912, Role.CUSTOMER);
        userRepo.save(adm);
        userRepo.save(emp);
        userRepo.save(mem);
        userRepo.save(cus);
        userService = new UserService(userRepo);
    }

    @Test
    void getUsers() {
        List<UserResponse> users = userService.getUsers();
        assertEquals(4, users.size());
        assertInstanceOf(UserResponse.class, users.get(0));
    }

    @Test
    void getUser() {
        User mem = new User(34567891, "mem", "c", "cc", "c@mail.com",
                "1234", Role.MEMBER);
        UserResponse userResOne = new UserResponse(mem, mem.getRole());
        UserResponse userResTwo = userService.getUser(34567891);
        assertEquals(userResOne.getPhoneNumber(), userResTwo.getPhoneNumber());
    }

    @Test
    void addUser() {
        UserRequest cusTwo = new UserRequest(88888888, Role.CUSTOMER);
        userService.addUser(cusTwo, cusTwo.getRole());
        List<UserResponse> users = userService.getUsers();
        assertEquals(5, users.size());
        assertEquals(88888888, userService.getUser(88888888).getPhoneNumber());
    }

    @Test
    void editUser() {
        int oldPhone = 12345678;
        int newPhone = 87654321;

        UserRequest adm = new UserRequest(oldPhone, "adm", "a", "aa", "a@mail.com",
                "1234", "street", "city", 2000, Role.ADMIN);

        assertEquals(userService.getUser(oldPhone).getPhoneNumber(), oldPhone);

        UserResponse userToEdit = userService.editUser(adm, newPhone);
        assertEquals(userToEdit.getPhoneNumber(), newPhone);
        assertEquals(userService.getUser(newPhone).getPhoneNumber(), newPhone);

    }

    @Test
    void deleteUser() {
        assertEquals(userService.getUser(45678912).getPhoneNumber(), 45678912);
        assertEquals(4, userService.getUsers().size());

        userService.deleteUser(45678912);

        assertEquals(3, userService.getUsers().size());
        assertThrows(Client4xxException.class, () -> userService.getUser(45678912));
    }
}