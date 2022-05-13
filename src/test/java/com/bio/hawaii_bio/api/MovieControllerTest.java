package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.repo.MovieRepo;
import com.bio.hawaii_bio.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")// Will prevent the DataSetup CommandLineRunner from running
@AutoConfigureMockMvc
@SpringBootTest // Vi får en fuld application context
// rolls back db to original value set in @BeforeAll
@Transactional
class MovieControllerTest {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private static Movie movie1;
    private static Movie movie2;

    @BeforeAll // statisk - kører før alle test.
    public static void setUp(@Autowired MovieRepo movieRepo) { // skal autowires sådan pga statisk metode
        movie1 = movieRepo.save(new Movie("Blood Sport", Category.ACTION,100,"Kampsportsfilm",12,
                "wevwe"));
        movie2 = movieRepo.save(new Movie("Street Fighter", Category.ACTION,100,"Kampsportsfilm",12,"wervwerv"));
    }

    @Test
    void getMovies() {
    }

    @Test
    void testGetMovie() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/movies/" + movie1.getId())
                .accept(MediaType.APPLICATION_JSON)) // tre første linjer laver request op mod server
                .andDo(print()) // respons retur fra denne linje (builderpattern)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(movie1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(movie1.getTitle()));
    }


    @Test
    void addMovie() {
    }
}