package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.TicketRequest;
import com.bio.hawaii_bio.dto.TicketResponse;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Ticket;
import com.bio.hawaii_bio.repo.TicketRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TicketServiceTest {
    @Autowired
    TicketRepo ticketRepo;

    TicketService ticketService;
    Performance performance;

    @BeforeEach
    void setUp() {

        Ticket ticket1 = new Ticket();
        ticket1.setId(1);
        ticket1.setTicketPrice(220);
        ticket1.setPerformance(performance);
        ticketRepo.save(ticket1);

        Ticket ticket2 = new Ticket();
        ticket2.setTicketPrice(400);
        ticket2.setId(2);
        ticket2.setPerformance(performance);
        ticketRepo.save(ticket2);
        ticketService = new TicketService(ticketRepo);
    }


    @Test
    void getTickets() {
        List<TicketResponse> tickets = ticketService.getTickets();
        assertEquals(2, tickets.size());
    }

//    @Test
//    void getTicket() {
//
//        performance.setId(4);
//        Ticket tick = new Ticket("t", 200, performance);
//        tick.setId(12);
//
//        TicketResponse ticketResponse1 = new TicketResponse(tick, false);
//        TicketResponse ticketResponse2 = ticketService.getTicket(12);
//        assertEquals(ticketResponse1.getId(), ticketResponse2.getId());
//    }
}