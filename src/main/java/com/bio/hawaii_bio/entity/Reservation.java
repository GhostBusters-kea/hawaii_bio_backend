package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.ReservationRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private LocalDateTime reservationDate;


    @ManyToOne
    private Ticket reservedTicket;

    @ManyToOne
    @JoinColumn(name="ticketid", referencedColumnName = "id")
    private Ticket ticket;

    public Reservation(ReservationRequest body){
        this.ticket=body.getTicket();
    }

}
