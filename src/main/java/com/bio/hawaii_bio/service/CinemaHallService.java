package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import com.bio.hawaii_bio.dto.CinemaHallResponse;
import com.bio.hawaii_bio.dto.MovieRequest;
import com.bio.hawaii_bio.entity.CinemaHall;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.CinemaHallRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {
    CinemaHallRepo cinemaHallRepo;

    public CinemaHallService(CinemaHallRepo cinemaHallRepo) {
        this.cinemaHallRepo = cinemaHallRepo;
    }

    public List<CinemaHallResponse> getCinemaHalls(){
        List<CinemaHall> cinemaHalls = cinemaHallRepo.findAll();
        return CinemaHallResponse.getCinemaHallsFromEntities(cinemaHalls);
    }

    public CinemaHallResponse getCinemaHall(int id){
        CinemaHall cinemaHall = cinemaHallRepo.findById(id).orElseThrow(() -> new Client4xxException("CinemaHall with that id"));
        return new CinemaHallResponse(cinemaHall);
    }

    public void addCinemaHall(CinemaHallRequest body){
        cinemaHallRepo.save(new CinemaHall(body));
    }

    public CinemaHallResponse editCinemaHall(CinemaHallRequest body, int cinemaHallId){
        CinemaHall cinemaHall = cinemaHallRepo.findById(cinemaHallId).orElseThrow(() -> new Client4xxException("CinemaHall with that id"));
        cinemaHall.setId(body.getId());
        cinemaHallRepo.save(cinemaHall);
        return new CinemaHallResponse(cinemaHall);
    }
}
