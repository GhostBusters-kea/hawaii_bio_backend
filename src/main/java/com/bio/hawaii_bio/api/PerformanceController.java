package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.PerformanceRequest;
import com.bio.hawaii_bio.dto.PerformanceResponse;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.service.MovieService;
import com.bio.hawaii_bio.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/performance")
public class PerformanceController {
    PerformanceService performanceService;
    MovieService movieService;

    public PerformanceController(PerformanceService performanceService, MovieService movieService) {
        this.performanceService = performanceService;
        this.movieService = movieService;
    }

    @GetMapping
    public List<PerformanceResponse> getPerformances(){
        return performanceService.getPerformances();
    }

    @GetMapping("/{id}")
    public List<PerformanceResponse> getPerformancesOnId(@PathVariable int id){
        return (performanceService.getPerformanceOnMovieId(id));
    }

    @PostMapping
    public void addNewPerformance(@RequestBody PerformanceRequest body){
        performanceService.addNewPerformance(body);
    }

    @PutMapping("/{id}")
    public PerformanceResponse editPerformance(@RequestBody PerformanceRequest body,@PathVariable int id){
        return performanceService.editPerformance(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable int id){
        performanceService.deletePerformance(id);
    }

    @PutMapping("/{performanceId}/movies/{movieId}")
    public void addMovieToPerformance(
            @PathVariable int performanceId,
            @PathVariable int movieId
    ){
        Performance performance = performanceService.getPerformanceById(performanceId);
        Movie movie = movieService.getMovieById(movieId);
        performance.setMovie(movie);
        performanceService.addMovieToPerformance(performance);

    }

}
