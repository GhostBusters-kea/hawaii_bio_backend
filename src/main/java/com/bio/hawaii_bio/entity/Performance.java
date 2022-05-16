package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.PerformanceRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime date;

    @JsonIgnore // for at undgå recursive problemet
    @OneToMany(mappedBy = "performance", fetch = FetchType.EAGER)
    private Set<Ticket> tickets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cinemahallid", referencedColumnName = "id")
    private CinemaHall cinemaHall;


    @ManyToOne
    @JoinColumn(name="movieid", referencedColumnName = "id")
    private Movie movie;

    public Performance(PerformanceRequest body){
        this.id = body.getId();
        this.date = body.getDate();
        this.movie = body.getMovie();
        this.cinemaHall = body.getCinemaHall();
    }

    public Performance(LocalDateTime date, Movie movie){
        this.date=date;
        this.movie=movie;
        movie.addPerformance(this);
    }

    public void setMovie(Movie movie){
        this.movie=movie;
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

}
