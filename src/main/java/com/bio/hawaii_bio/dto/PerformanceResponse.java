package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.entity.Performance;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PerformanceResponse {
    private int id;
    private LocalDateTime date;
    private Movie movie;

    public PerformanceResponse(Performance performance){
        this.id = performance.getId();
        this.date = performance.getDate();
        this.movie = performance.getMovie();
    }

    public static List<PerformanceResponse> getPerfromanceFromEntities(List<Performance> performances){
        return performances.stream().map(performance -> new PerformanceResponse(performance)).collect(Collectors.toList());
    }

}
