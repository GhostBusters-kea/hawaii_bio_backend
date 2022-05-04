package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.PerformanceRequest;
import com.bio.hawaii_bio.dto.PerformanceResponse;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/performance")
public class PerformanceController {
    PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping
    public List<PerformanceResponse> getPerformances(){
        return performanceService.getPerformances();
    }

    @GetMapping("/{id}")
    public PerformanceResponse getPerformancesOnId(@PathVariable int id){
        return (performanceService.getPerformance(id));
    }

    @PostMapping
    public PerformanceResponse addNewPerformance(@RequestBody PerformanceRequest body){
        return performanceService.addNewPerformance(body);
    }

    @PutMapping("/{id}")
    public PerformanceResponse editPerformance(@RequestBody PerformanceRequest body,@PathVariable int id){
        return performanceService.editPerformance(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable int id){
        performanceService.deletePerformance(id);
    }
}
