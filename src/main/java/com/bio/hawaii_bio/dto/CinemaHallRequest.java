package com.bio.hawaii_bio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaHallRequest {
    private int id;
    private int seats;
    private int seatsReserved;
}
