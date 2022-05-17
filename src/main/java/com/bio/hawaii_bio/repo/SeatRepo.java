package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
