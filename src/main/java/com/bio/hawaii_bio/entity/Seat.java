package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.SeatRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    private int id;


    public Seat(SeatRequest body){
        this.id = body.getId();

    }

    public Seat(int id){
        this.id = id;
    }
}
