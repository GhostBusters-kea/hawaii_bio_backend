package com.bio.hawaii_bio.dto;


import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Reservation;
import com.bio.hawaii_bio.entity.Ticket;
import com.bio.hawaii_bio.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString

public class ReservationResponse {

    private int id;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime reservationDate;
    private List<Integer> ticketIds;
    private String username;

    public ReservationResponse(Reservation reservation){
        this.id=reservation.getId();
        this.reservationDate=reservation.getReservationDate();
        this.username = reservation.getUser().getUsername();
        this.ticketIds = reservation.getTickets().stream().map(ticket -> ticket.getId()).collect(Collectors.toList());
    }

    public static List<ReservationResponse> getReservationFromEntities(List<Reservation> reservations){
        return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    }


}