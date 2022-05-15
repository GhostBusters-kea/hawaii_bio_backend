package com.bio.hawaii_bio.service;


import com.bio.hawaii_bio.dto.TicketRequest;
import com.bio.hawaii_bio.dto.TicketResponse;
import com.bio.hawaii_bio.entity.Ticket;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.TicketRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    TicketRepo ticketRepo;


    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public List<TicketResponse> getTickets(){
        List<Ticket> tickets = ticketRepo.findAll();
        return TicketResponse.getTicketFromEntities(tickets);
    }

    public TicketResponse getTicket(int id){
        Ticket ticket = ticketRepo.findById(id).orElseThrow(()-> new Client4xxException("No performance with that id"));
        return new TicketResponse(ticket, false);
    }

    public TicketResponse addNewTicket(TicketRequest body){
        Ticket ticket = ticketRepo.save(new Ticket(body));
        return new TicketResponse(ticket, false);
    }

    public TicketResponse editTicket(TicketRequest body, int ticketId){
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow(() -> new Client4xxException("no ticket found"));
        ticket.setPerformance(body.getPerformance());
        ticket.setTicketType(body.getTicketType());
        ticket.setTicketPrice(body.getTicketPrice());
        return new TicketResponse(ticket, false);
    }

    public void deleteTicket (int ticketId){
        if(!ticketRepo.existsById(ticketId)){
            throw new Client4xxException("No ticket with that ID");
        }
        ticketRepo.deleteById(ticketId);
    }
}
