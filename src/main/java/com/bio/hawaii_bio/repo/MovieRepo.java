package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MovieRepo extends JpaRepository<Movie, Integer> {

    List<Movie> findMoviesByCategory(Category category);

}
