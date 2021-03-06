package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Seat;
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
    private Seat seat;
}
