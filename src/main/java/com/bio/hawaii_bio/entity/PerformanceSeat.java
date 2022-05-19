package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.PerformanceSeatRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PerformanceSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "seatid", referencedColumnName = "id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "performanceid", referencedColumnName = "id")
    private Performance performance;

    private int isreserved;

    public PerformanceSeat(PerformanceSeatRequest body){
        this.id = body.getId();
        this.seat = body.getSeat();
        this.performance = body.getPerformance();
        this.isreserved = body.getIsreserved();
    }

}
