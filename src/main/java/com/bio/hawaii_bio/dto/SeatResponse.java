package com.bio.hawaii_bio.dto;

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
    private int isReserved;

    public SeatResponse(Seat seat){
        this.id = seat.getId();
        this.isReserved = seat.getIsReserved();
    }

    public static List<SeatResponse> getSeatsFromEntity(List<Seat> seats){
        return seats.stream().map(seat -> new SeatResponse(seat)).collect(Collectors.toList());
    }
}
