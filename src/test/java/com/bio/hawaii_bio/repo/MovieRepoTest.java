package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Category;
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
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        movie1.setCategory(Category.SCIENCE_FICTION);
        movie2.setCategory(Category.DRAMA);
        movieRepo.save(movie1);
        movieRepo.save(movie2);
        movieid1 = movie1.getId(); // Vi gemmer i test-db
        movieid2= movie2.getId();


    }

    @Test
    public void testGetMovies(){
        List<Movie> movies = movieRepo.findAll();
        assertEquals(2, movies.size());
    }

    @Test
    public void testFindMoviesByCategory(){
        List<Movie> movies = movieRepo.findMoviesByCategory(Category.SCIENCE_FICTION);
        assertEquals(1, movies.size());
        assertEquals(Category.SCIENCE_FICTION, movies.get(0).getCategory());


    }

}