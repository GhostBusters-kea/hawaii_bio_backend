package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private int id;
    private LocalDateTime reservationDate;
    private int amountOfTickets;
    private Ticket ticket;
}