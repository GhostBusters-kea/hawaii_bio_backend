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



    public Ticket(TicketRequest body){
        this.id = body.getId();
        this.TicketType = body.getTicketType();
        this.amountOfTickets = body.getAmountOfTickets();
        this.ticketPrice = body.getTicketPrice();
        this.performance = body.getPerformance();
    }

    private String TicketType;
    private int amountOfTickets;
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

