package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import com.bio.hawaii_bio.dto.CinemaHallResponse;
import com.bio.hawaii_bio.service.CinemaHallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("api/cinemahall")
public class CinemahallController {
    CinemaHallService cinemaHallService;

    public CinemahallController(CinemaHallService cinemaHallService) {
        this.cinemaHallService = cinemaHallService;
    }

    @GetMapping
    public List<CinemaHallResponse> getCinemaHalls(){
        return cinemaHallService.getCinemaHalls();
    }

    @GetMapping("/{id}")
    public CinemaHallResponse getCinemaHallOnId(@PathVariable int id){
        return cinemaHallService.getCinemaHall(id);
    }

    @PutMapping("/{id}")
    public CinemaHallResponse editCinemaHall(@RequestBody CinemaHallRequest body, @PathVariable int id){
        return cinemaHallService.editCinemaHall(body, id);
    }
}
