package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
