package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceRequest {
    private LocalDateTime date;
    private Movie movie;

}
