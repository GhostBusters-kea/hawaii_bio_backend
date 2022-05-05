package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.TicketRequest;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Ticket {

    @Id
    private int id;

    @CreationTimestamp
    private LocalDateTime ticketCreatedDate;

    @ManyToOne
    @JoinColumn(name="performanceid", referencedColumnName = "id")
    private Performance dateOfPerformance;

    private int amountOfTickets;
    private String TicketType;
    private double ticketPrice;

    public Ticket(TicketRequest body){
        this.id = body.getId();
        this.amountOfTickets = body.getAmountOfTickets();
        this.TicketType = body.getTicketType();
        this.ticketPrice = body.getTicketPrice();
        this.dateOfPerformance = body.getDateOfPerformance();
    }

    public Ticket() {
    }
}

