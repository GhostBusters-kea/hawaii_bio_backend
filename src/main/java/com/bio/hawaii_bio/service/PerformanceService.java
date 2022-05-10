package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.PerformanceRequest;
import com.bio.hawaii_bio.dto.PerformanceResponse;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.PerformanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    PerformanceRepo performanceRepo;

    public PerformanceService(PerformanceRepo performanceRepo){
        this.performanceRepo = performanceRepo;
    }

    public List<PerformanceResponse> getPerformances(){
        List<Performance> performances = performanceRepo.findAll();
        return PerformanceResponse.getPerfromanceFromEntities(performances);
    }

    public PerformanceResponse getPerformance(int id){
        Performance performance = performanceRepo.findById(id).orElseThrow(()-> new Client4xxException("No performance with that id"));
        return new PerformanceResponse(performance);
    }

    public List<PerformanceResponse> getPerformanceOnMovieId(int id){
        List<Performance> performances = performanceRepo.findPerformancesByMovieId(id);
        return PerformanceResponse.getPerfromanceFromEntities(performances);
    }

    public PerformanceResponse addNewPerformance(PerformanceRequest body){
        Performance performance = performanceRepo.save(new Performance(body));
        return new PerformanceResponse(performance);
    }

    public PerformanceResponse editPerformance(PerformanceRequest body, int performanceId){
        Performance performance = performanceRepo.findById(performanceId).orElseThrow(() -> new Client4xxException("no performance"));
        performance.setDate(body.getDate());
        performance.setMovie(body.getMovie());
        return new PerformanceResponse(performance);
    }

    public void deletePerformance(int performanceId){
        if(!performanceRepo.existsById(performanceId)){
            throw new Client4xxException("No performance with that ID");
        }
        performanceRepo.deleteById(performanceId);
    }
}
