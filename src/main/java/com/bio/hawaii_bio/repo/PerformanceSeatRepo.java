package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.PerformanceSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceSeatRepo extends JpaRepository<PerformanceSeat, Integer> {
    List<PerformanceSeat> findPerformanceSeatByPerformanceId(int performanceId);
}
