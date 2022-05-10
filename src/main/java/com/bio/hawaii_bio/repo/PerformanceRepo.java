package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepo extends JpaRepository<Performance, Integer> {
    List<Performance> findPerformancesByMovieId(int movieId);
}
