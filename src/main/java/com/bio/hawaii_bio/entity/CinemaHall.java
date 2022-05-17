package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CinemaHall {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "seatid", referencedColumnName = "id")
    private Seat seat;


    public CinemaHall(CinemaHallRequest body){
        this.id = body.getId();
        this.seat = body.getSeat();
    }
}
