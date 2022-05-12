package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class UserControllerTest {

    @Autowired
    UserRepo userRepo;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private static User user1;
    private static User user2;

    @BeforeAll
    public static void setUp(@Autowired UserRepo userRepo) {
        user1 = userRepo.save(new User(34567891, "mem", "c", "cc", "c@mail.com",
                "1234", Role.MEMBER));
        user2 = userRepo.save(new User(23456789, "emp", "b", "bb", "b@mail.com",
                "1234", "street", "city", 2000, Role.EMPLOYEE));
    }

    @Test
    void getMembers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                    .get("/api/users")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.content().string(containsString("cc")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("bb")));
    }

    @Test
    void getMember() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/" + user1.getPhoneNumber())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value(user1.getPhoneNumber()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(user1.getFirstName()));

    }

//    @Test
//    void addMember() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/api/users/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath())
//    }

    @Test
    void editMember() {
    }

    @Test
    void deleteMember() {
    }
}