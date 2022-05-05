package com.bio.hawaii_bio.dto;


import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Reservation;
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
    private TicketResponse ticketResponse;

    public ReservationResponse(Reservation reservation){
        this.id=reservation.getId();
        this.reservationDate=reservation.getReservationDate();
        this.ticketResponse= new TicketResponse(reservation.getTicket(),false);
    }

    public static List<ReservationResponse> getReservationFromEntities(List<Reservation> reservations){
        return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    }


}