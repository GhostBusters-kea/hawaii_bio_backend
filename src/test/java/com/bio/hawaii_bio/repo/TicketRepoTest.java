package com.bio.hawaii_bio.repo;


import com.bio.hawaii_bio.entity.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TicketRepoTest {

    @Autowired
    TicketRepo ticketRepo;

    @BeforeEach
    void setUp(@Autowired TicketRepo ticketRepo){
        Ticket ticket1 = new Ticket();
        ticket1.setId(1);
        ticket1.setTicketPrice(200);
        ticketRepo.save(ticket1);
        Ticket ticket2 = new Ticket();
        ticket2.setId(2);
        ticket2.setTicketPrice(200);
        ticketRepo.save(ticket2);
    }
    @Test
    public void testGetPerformances(){
        List<Ticket> tickets = ticketRepo.findAll();
        assertEquals(2, tickets.size());
    }
}