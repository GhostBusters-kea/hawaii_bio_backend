package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Reservation;
import com.bio.hawaii_bio.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private int id;
    private Performance performance;
    private double ticketPrice;
    private int seatname;
    private Reservation reservation;
    private Set<Ticket> tickets;
}
