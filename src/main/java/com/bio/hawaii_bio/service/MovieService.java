package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.MovieRequest;
import com.bio.hawaii_bio.dto.MovieResponse;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.MovieRepo;
import org.springframework.stereotype.Service;

import java.net.CacheRequest;
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


    // Only for admins
    public void addMovie(MovieRequest body){
        Movie movie = movieRepo.save(new Movie(body));
    }

    public void editMovie(MovieRequest body, int movieId){
        Movie movie = movieRepo.findById(movieId).orElseThrow(()-> new Client4xxException("No movie with that Id"));
        movie.setTitle(body.getTitle());
        movie.setCategory(body.getCategory());
        movie.setDescription(body.getDescription());
        movie.setAgeLimit(body.getAgeLimit());
    }

    public void deleteMovie(int movieId){
        if(!movieRepo.existsById(movieId)){
            throw new Client4xxException("No movie with that Id");
        }
        movieRepo.deleteById(movieId);
    }
}
