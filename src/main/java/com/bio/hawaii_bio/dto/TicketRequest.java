package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Performance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private int id;
    private Performance dateOfPerformance;
    private int amountOfTickets;
    private String ticketType;
    private double ticketPrice;
}
