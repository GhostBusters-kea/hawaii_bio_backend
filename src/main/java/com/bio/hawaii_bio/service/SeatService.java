package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.SeatRequest;
import com.bio.hawaii_bio.dto.SeatResponse;
import com.bio.hawaii_bio.entity.Seat;
import com.bio.hawaii_bio.error.Client4xxException;
import com.bio.hawaii_bio.repo.SeatRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    SeatRepo seatRepo;

    public SeatService(SeatRepo seatRepo) {
        this.seatRepo = seatRepo;
    }

    public List<SeatResponse> getSeats(){
        List<Seat> seats = seatRepo.findAll();
        return SeatResponse.getSeatsFromEntity(seats);
    }

    public SeatResponse getSeat(int id){
        Seat seat = seatRepo.findById(id).orElseThrow(() -> new Client4xxException("no id"));
        return new SeatResponse(seat);
    }

    public void addSeat(SeatRequest body){
        seatRepo.save(new Seat(body));
    }

    public SeatResponse editSeat(SeatRequest body, int seatId){
        Seat seat = seatRepo.findById(seatId).orElseThrow(() -> new Client4xxException("no id"));
        seat.setId(body.getId());
        seatRepo.save(seat);
        return new SeatResponse(seat);
    }
}
