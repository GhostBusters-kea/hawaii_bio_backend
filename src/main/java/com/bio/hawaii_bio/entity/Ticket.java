package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.TicketRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private LocalDateTime ticketCreatedDate;

    @ManyToOne
    @JoinColumn(name="performanceid", referencedColumnName = "id")
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    private int seatname;


    public Ticket(TicketRequest body){
        this.id = body.getId();
        this.ticketPrice = body.getTicketPrice();
        this.performance = body.getPerformance();
        this.seatname = body.getSeatname();
        this.reservation = body.getReservation();
    }

    private String TicketType;
    private double ticketPrice;

    public Ticket(String ticketType, double ticketPrice, Performance performance){
        this.TicketType = ticketType;
        this.ticketPrice = ticketPrice;
        performance.addTicket(this);
    }
    public void setPerformance(Performance performance){
        this.performance = performance;
    }



    public Ticket() {
    }
}

