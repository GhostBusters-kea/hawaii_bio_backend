package com.bio.hawaii_bio.entity;


import com.bio.hawaii_bio.dto.MovieRequest;
import com.bio.hawaii_bio.dto.MovieResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "ENUM('THRILLER', 'COMEDY', 'ROMANCE', 'SCIENCE_FICTION', 'HORROR', 'ADVENTURE', 'DRAMA', 'ACTION')")
    @Enumerated(EnumType.STRING)
    private Category category;
    private int length;
    private String description;
    private int ageLimit;
    private String imageUrl;

    @JsonIgnore // for at undgå recursive problemet
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private Set<Performance> performances = new HashSet<>();

    public Movie(MovieRequest body){
        this.id = body.getId();
        this.category=body.getCategory();
        this.title=body.getTitle();
        this.length=body.getLength();
        this.description= body.getDescription();
        this.ageLimit=body.getAgeLimit();
    }

    public Movie(String title, Category category, int length, String description, int ageLimit, String imageUrl) {
        this.title = title;
        this.category = category;
        this.length = length;
        this.description = description;
        this.ageLimit = ageLimit;
        this.imageUrl=imageUrl;
    }

    public void addPerformance(Performance performance){
        performances.add(performance);
    }
}


