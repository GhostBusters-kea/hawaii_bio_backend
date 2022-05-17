package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.CinemaHall;
import com.bio.hawaii_bio.entity.Movie;
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
public class CinemaHallResponse {
    private int id;

    private Seat seat;

    public CinemaHallResponse(CinemaHall cinemaHall){
        this.id = cinemaHall.getId();
        this.seat = cinemaHall.getSeat();

    }

    public static List<CinemaHallResponse> getCinemaHallsFromEntities(List<CinemaHall> cinemaHalls){
        return cinemaHalls.stream().map(cinemaHall -> new CinemaHallResponse(cinemaHall)).collect(Collectors.toList());
    }
}
