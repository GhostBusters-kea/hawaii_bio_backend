package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.TicketRequest;
import com.bio.hawaii_bio.dto.TicketResponse;
import com.bio.hawaii_bio.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ticket")
public class TicketController {


    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
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

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable int id){
        ticketService.deleteTicket(id);
    }
}

