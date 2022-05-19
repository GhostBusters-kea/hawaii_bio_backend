package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.PerformanceSeat;
import com.bio.hawaii_bio.entity.Seat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceSeatResponse {
    private int id;
    private Seat seat;
    private Performance performance;
    private int isreserved;


    public PerformanceSeatResponse(PerformanceSeat performanceSeat){
        this.id = performanceSeat.getId();
        this.seat = performanceSeat.getSeat();
        this.performance = performanceSeat.getPerformance();
        this.isreserved = performanceSeat.getIsreserved();
    }

    public static List<PerformanceSeatResponse> getPerformanceSeatsFromEntity(List<PerformanceSeat> performanceSeats){
        return performanceSeats.stream().map(performanceSeat -> new PerformanceSeatResponse(performanceSeat)).collect(Collectors.toList());
    }
}
