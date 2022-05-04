package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CinemaHall {
    @Id
    private int id;


    private int seats;

    private int seatsReserved;

    public CinemaHall(CinemaHallRequest body){
        this.id = body.getId();
        this.seats = body.getSeats();
        this.seatsReserved = body.getSeatsReserved();
    }

}
