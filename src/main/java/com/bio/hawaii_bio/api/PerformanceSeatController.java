package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.PerformanceSeatRequest;
import com.bio.hawaii_bio.dto.PerformanceSeatResponse;
import com.bio.hawaii_bio.dto.SeatRequest;
import com.bio.hawaii_bio.dto.SeatResponse;
import com.bio.hawaii_bio.service.PerformanceSeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/performanceseat")
public class PerformanceSeatController {
    PerformanceSeatService performanceSeatService;

    public PerformanceSeatController(PerformanceSeatService performanceSeatService) {
        this.performanceSeatService = performanceSeatService;
    }

    @GetMapping
    public List<PerformanceSeatResponse> getPerformanceSeats(){
        return performanceSeatService.getPerformanceSeats();
    }

    @GetMapping("/{id}")
    public List<PerformanceSeatResponse> getPerformanceSeatOnId(@PathVariable int id){
        return performanceSeatService.getPerformanceSeat(id);
    }

    @PostMapping
    public void addPerformanceSeat(@RequestBody PerformanceSeatRequest body){
        performanceSeatService.addPerformanceSeat(body);
    }

    @PutMapping("/{id}")
    public PerformanceSeatResponse editPerformanceSeat(@RequestBody PerformanceSeatRequest body, @PathVariable int id){
        return performanceSeatService.editPerformanceSeat(body, id);
    }

}
