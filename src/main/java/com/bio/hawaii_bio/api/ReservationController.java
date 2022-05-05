package com.bio.hawaii_bio.api;

import com.bio.hawaii_bio.dto.ReservationRequest;
import com.bio.hawaii_bio.dto.ReservationResponse;
import com.bio.hawaii_bio.service.ReservationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/reservation")
public class ReservationController {


    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationResponse> getReservations(){
        return reservationService.getReservations();
    }
    @GetMapping("/{id}")
    public ReservationResponse getReservationOnId(@PathVariable int id){
        return (reservationService.getReservation(id));
    }
    @PostMapping
    public ReservationResponse addNewReservation(@RequestBody ReservationRequest body){
        return reservationService.addNewReservation(body);
    }

    @PutMapping("/{id}")
    public ReservationResponse editReservation(@RequestBody ReservationRequest body,@PathVariable int id){
        return reservationService.editReservation(body, id);
    }
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationService.deleteReservation(id);
    }
}

