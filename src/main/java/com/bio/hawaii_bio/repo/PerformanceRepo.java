package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepo extends JpaRepository<Performance, Integer> {
}
