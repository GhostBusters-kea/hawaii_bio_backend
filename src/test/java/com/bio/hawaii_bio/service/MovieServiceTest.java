package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.MovieResponse;
import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.repo.MovieRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieServiceTest {
    @Autowired
    MovieRepo movieRepo;

    MovieService movieService;

    @BeforeEach
    public void setUp() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        movie1.setCategory(Category.SCIENCE_FICTION);
        movie2.setCategory(Category.DRAMA);
        movie1.setTitle("The Northman");
        movie2.setTitle("The Revenant");
        movieRepo.save(movie1);
        movieRepo.save(movie2);
        movieService = new MovieService(movieRepo);



    }

    @Test
    void getMovies() {
        List<MovieResponse> movies = movieService.getMovies();
        assertEquals(2, movies.size());
        assertInstanceOf(MovieResponse.class,movies.get(0));


    }

    @Test
    void addMovie() {
    }
}