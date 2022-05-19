package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.CinemaHall;
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
public class SeatResponse {
    private int id;

    public SeatResponse(Seat seat){
        this.id = seat.getId();
    }

    public static List<SeatResponse> getSeatsFromEntity(List<Seat> seats){
        return seats.stream().map(seat -> new SeatResponse(seat)).collect(Collectors.toList());
    }
}
