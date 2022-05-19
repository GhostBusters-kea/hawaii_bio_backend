package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.PerformanceSeatRequest;
import com.bio.hawaii_bio.dto.PerformanceSeatResponse;
import com.bio.hawaii_bio.dto.SeatResponse;
import com.bio.hawaii_bio.entity.PerformanceSeat;
import com.bio.hawaii_bio.entity.Seat;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.PerformanceSeatRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceSeatService {
    PerformanceSeatRepo performanceSeatRepo;

    public PerformanceSeatService(PerformanceSeatRepo performanceSeatRepo) {
        this.performanceSeatRepo = performanceSeatRepo;
    }

    public List<PerformanceSeatResponse> getPerformanceSeats(){
        List<PerformanceSeat> performanceSeats = performanceSeatRepo.findAll();
        return PerformanceSeatResponse.getPerformanceSeatsFromEntity(performanceSeats);
    }

    public List<PerformanceSeatResponse> getPerformanceSeat(int performanceId){
        List<PerformanceSeat> performanceSeat = performanceSeatRepo.findPerformanceSeatByPerformanceId(performanceId);
        return PerformanceSeatResponse.getPerformanceSeatsFromEntity(performanceSeat);
    }

    public void addPerformanceSeat(PerformanceSeatRequest body){
        performanceSeatRepo.save(new PerformanceSeat(body));
    }

    public PerformanceSeatResponse editPerformanceSeat(PerformanceSeatRequest body, int id){
        PerformanceSeat performanceSeat = performanceSeatRepo.findById(id).orElseThrow(() -> new Client4xxException("no id"));
        performanceSeat.setId(body.getId());
        performanceSeat.setSeat(body.getSeat());
        performanceSeat.setPerformance(body.getPerformance());
        performanceSeat.setIsreserved(body.getIsreserved());
        performanceSeatRepo.save(performanceSeat);
        return new PerformanceSeatResponse(performanceSeat);
    }
}
