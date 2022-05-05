package com.bio.hawaii_bio.api;


import com.bio.hawaii_bio.dto.MovieRequest;
import com.bio.hawaii_bio.dto.MovieResponse;
import com.bio.hawaii_bio.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/movies")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieResponse> getMovies(){
        return movieService.getMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovie(@PathVariable int id){
        return movieService.getMovie(id,true);
    }

    // Only for admins
    @PostMapping
    public void addMovie(@RequestBody MovieRequest body){
        movieService.addMovie(body);
    }

    @PutMapping("/{id}")
    public void editMovie(@RequestBody MovieRequest body, @PathVariable int id){
        movieService.editMovie(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
    }

}
