package com.bio.hawaii_bio.entity;


import com.bio.hawaii_bio.dto.MovieRequest;
import com.bio.hawaii_bio.dto.MovieResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "ENUM('THRILLER', 'COMEDY', 'ROMANCE', 'SCIENCE_FICTION','HORROR','ADVENTURE','DRAMA','ACTION')")
    @Enumerated(EnumType.STRING)
    private Category category;
    private int length;
    private String description;
    private int ageLimit;


    public Movie(MovieRequest body){
        this.category=body.getCategory();
        this.title=body.getTitle();
        this.length=body.getLength();
        this.description= body.getDescription();
        this.ageLimit=body.getAgeLimit();
    }
}


