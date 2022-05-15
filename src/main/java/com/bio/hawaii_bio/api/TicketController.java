package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.PerformanceResponse;
import com.bio.hawaii_bio.dto.TicketRequest;
import com.bio.hawaii_bio.dto.TicketResponse;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.entity.Ticket;
import com.bio.hawaii_bio.service.PerformanceService;
import com.bio.hawaii_bio.service.TicketService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ticket")
public class TicketController {


    TicketService ticketService;
    PerformanceService performanceService;


    public TicketController(TicketService ticketService, PerformanceService performanceService) {
        this.ticketService = ticketService;
        this.performanceService = performanceService;
    }




    @GetMapping
    public List<TicketResponse> getTickets(){
        return ticketService.getTickets();
    }

    @GetMapping("/{id}")
    public TicketResponse getTicketOnId(@PathVariable int id){
        return (ticketService.getTicket(id));
    }

    @PostMapping
    public TicketResponse addNewTicket(@RequestBody TicketRequest body){
        return ticketService.addNewTicket(body);
    }

    @PutMapping("/{id}")
    public TicketResponse editTicket(@RequestBody TicketRequest body,@PathVariable int id){
        return ticketService.editTicket(body, id);
    }
//
//    @PutMapping("/{ticketId}/performance/{performanceid}")
//    public void addPerformanceToTicket(
//            @PathVariable int ticketId,
//            @PathVariable int performanceid
//    ){
//
//        Ticket ticket = ticketService.getTicketById(ticketId);
//        Performance performance = performanceService.getPerformanceById(performanceid);
//        ticket.setPerformance(performance);
//        ticketService.addPerformanceToTicket(ticket);
//
//    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id){
        ticketService.deleteTicket(id);
    }
}

