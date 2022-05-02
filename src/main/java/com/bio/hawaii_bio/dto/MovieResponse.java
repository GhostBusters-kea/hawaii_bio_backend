package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {
    private int id;
    private Category category;
    private String title;
    private int length;
    private String description;
    private int ageLimit;

    public MovieResponse(Movie movie, boolean includeAll){
        this.category=movie.getCategory();
        this.title= movie.getTitle();
        this.length= movie.getLength();
        this.ageLimit= movie.getAgeLimit();
        this.description= movie.getDescription();
        if(includeAll){
            this.id= movie.getId();
        }
    }

    public static List<MovieResponse> getMoviesFromEntities(List<Movie> movies){
        return movies.stream().map(movie -> new MovieResponse(movie, false)).collect(Collectors.toList());
    }

}


