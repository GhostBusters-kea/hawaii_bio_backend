package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.PerformanceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="movieid", referencedColumnName = "id")
    private Movie movie;

    public Performance(PerformanceRequest body){
        this.date = body.getDate();
        this.movie = body.getMovie();
    }
}
