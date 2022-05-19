package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Reservation;
import com.bio.hawaii_bio.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private int id;
    private Performance performance;
    private double ticketPrice;
    //private int hall_id;
    private int seatname;
    private Reservation reservation;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;

    public TicketResponse(Ticket ticket){
        this.id = ticket.getId();
        this.performance = ticket.getPerformance();
        //this.hall_id = ticket.getPerformance().getCinemaHall().getId();
        this.ticketPrice = ticket.getTicketPrice();
        this.created = ticket.getTicketCreatedDate();
        this.seatname = ticket.getSeatname();
        this.reservation = ticket.getReservation();
    }

    public static List<TicketResponse> getTicketFromEntities(List<Ticket> tickets){
        return tickets.stream().map(ticket -> new TicketResponse(ticket)).collect(Collectors.toList());
    }
}

