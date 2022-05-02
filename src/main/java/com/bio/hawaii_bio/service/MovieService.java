package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.MovieResponse;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieResponse> getMovies(){
        List<Movie> movies = movieRepo.findAll();
        return MovieResponse.getMoviesFromEntities(movies);
    }

    public MovieResponse getMovie(int id, boolean all){
        Movie movie = movieRepo.findById(id).orElseThrow(() -> new Client4xxException("No movie with that Id"));
        return new MovieResponse(movie, all);
    }
}
