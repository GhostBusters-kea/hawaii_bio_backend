package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.CinemaHallRequest;
import com.bio.hawaii_bio.dto.CinemaHallResponse;
import com.bio.hawaii_bio.dto.SeatRequest;
import com.bio.hawaii_bio.dto.SeatResponse;
import com.bio.hawaii_bio.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/seat")
public class SeatController {
    SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<SeatResponse> getSeats(){
        return seatService.getSeats();
    }

    @GetMapping("/{id}")
    public SeatResponse getSeatOnId(@PathVariable int id){
        return seatService.getSeat(id);
    }

    @PostMapping
    public void addSeat(@RequestBody SeatRequest body){
        seatService.addSeat(body);
    }

    @PutMapping("/{id}")
    public SeatResponse editSeat(@RequestBody SeatRequest body, @PathVariable int id){
        return seatService.editSeat(body, id);
    }

}
