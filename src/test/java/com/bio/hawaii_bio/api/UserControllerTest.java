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
        user1 = new User("adm", "adm@mail.com", "1234");
        user2 = new User("mem", "user@mail.com", "1234");
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
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
                .get("/api/users/" + user1.getUsername())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value(user1.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(user1.getEmail()));

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