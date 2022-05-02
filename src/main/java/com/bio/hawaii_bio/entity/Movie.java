package com.bio.hawaii_bio.entity;


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
    @Column(columnDefinition = "ENUM('THRILLER', 'COMEDY', 'ROMANCE', 'SCIENCE_FICTION','HORROR')")
    @Enumerated(EnumType.STRING)
    private Category category;
    private int length;
    private String description;
    private int ageLimit;
}


