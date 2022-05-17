package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.SeatRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    private int id;

    private int isReserved = 0;

    public Seat(SeatRequest body){
        this.id = body.getId();
        this.id = body.getIsReserved();
    }

    public Seat(int id){
        this.id = id;
    }
}
