package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CinemaHall {
    @Id
    private int id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private int a1;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private int a2;

    public CinemaHall(CinemaHallRequest body){
        this.id = body.getId();
        this.a1 = body.getA1();
        this.a2 = body.getA2();
    }
}
