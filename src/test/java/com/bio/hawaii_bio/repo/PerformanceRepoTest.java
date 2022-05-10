package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Performance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@DataJpaTest
class PerformanceRepoTest {

    @Autowired
    PerformanceRepo performanceRepo;



    @BeforeEach
    void setUp(@Autowired PerformanceRepo performanceRepo) {
        Performance performance1 = new Performance();
        performance1.setDate(LocalDateTime.of(2010, Month.MARCH, 8, 12, 30));
        performance1.setId(1);
        performanceRepo.save(performance1);
        Performance performance2 = new Performance();
        performance2.setDate(LocalDateTime.of(2011, Month.MARCH, 10, 11, 20));
        performance2.setId(2);
        performanceRepo.save(performance2);
    }

    @Test
    public void testGetPerformances(){
        List<Performance> performances = performanceRepo.findAll();
        assertEquals(2, performances.size());
    }
}