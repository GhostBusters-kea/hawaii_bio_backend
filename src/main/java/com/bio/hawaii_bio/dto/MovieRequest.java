package com.bio.hawaii_bio.dto;

import com.bio.hawaii_bio.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private Category category;
    private String title;
    private int length;
    private String description;
    private int ageLimit;
}
