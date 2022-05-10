package com.bio.hawaii_bio.service;

import com.bio.hawaii_bio.dto.PerformanceResponse;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.repo.PerformanceRepo;
import com.bio.hawaii_bio.service.PerformanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PerformanceServiceTest {
    @Autowired
    PerformanceRepo performanceRepo;
    PerformanceService performanceService;


    @BeforeEach
    void setUp() {
        Performance performance1 = new Performance();
        performance1.setDate(LocalDateTime.of(2010, Month.MARCH, 8, 12, 30));
        performance1.setId(1);
        performanceRepo.save(performance1);
        Performance performance2 = new Performance();
        performance2.setDate(LocalDateTime.of(2011, Month.MARCH, 10, 11, 20));
        performance2.setId(2);
        performanceRepo.save(performance2);
        performanceService = new PerformanceService(performanceRepo);
    }

    @Test
    void getPerformances() {
        List<PerformanceResponse> performances = performanceService.getPerformances();
        assertEquals(2, performances.size());
    }
}