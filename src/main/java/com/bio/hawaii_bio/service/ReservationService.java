package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.ReservationRequest;
import com.bio.hawaii_bio.dto.ReservationResponse;
import com.bio.hawaii_bio.entity.Reservation;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.ReservationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {

    ReservationRepo reservationRepo;

    public ReservationService(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }
    public List<ReservationResponse> getReservations(){
        List<Reservation> reservations = reservationRepo.findAll();
        return ReservationResponse.getReservationFromEntities(reservations);
    }

    public ReservationResponse getReservation(int id){
        Reservation reservation = reservationRepo.findById(id).orElseThrow(()-> new Client4xxException("No reservation with that id"));
        return new ReservationResponse(reservation);
    }

    public ReservationResponse addNewReservation(ReservationRequest body){
        Reservation reservation = reservationRepo.save(new Reservation(body));
        return new ReservationResponse(reservation);
    }

    public ReservationResponse editReservation(ReservationRequest body, int reservationId){
        Reservation reservation = reservationRepo.findById(reservationId).orElseThrow(() -> new Client4xxException("no reservation with that id"));
        reservation.setReservationDate(body.getReservationDate());
        reservation.setTicket(body.getTicket());
        return new ReservationResponse(reservation);
    }
    public void deleteReservation(int reservationId){
        if(!reservationRepo.existsById(reservationId)){
            throw new Client4xxException("No reservation with that id");
        }
        reservationRepo.deleteById(reservationId);
    }
}
