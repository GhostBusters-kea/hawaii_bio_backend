package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Transactional
@DataJpaTest
class MovieRepoTest {

    @Autowired
    MovieRepo movieRepo;

    static int movieid1, movieid2;

    @BeforeEach
    void setUp(@Autowired MovieRepo movieRepo) {
        Movie movie1 = movieRepo.save(new Movie());
        movieid1 = movie1.getId();
        Movie movie2 = movieRepo.save(new Movie());
        movieid2= movie2.getId();

    }

    @Test
    public void testGetMovies(){
        List<Movie> movies = movieRepo.findAll();
        assertEquals(2, movies.size());
    }
}