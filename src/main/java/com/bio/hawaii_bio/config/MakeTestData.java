package com.bio.hawaii_bio.config;

import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.repo.MovieRepo;
import com.bio.hawaii_bio.service.MovieService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    MovieRepo movieRepo;

    public MakeTestData(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;

    }

    public void makeTestData(){

        Movie a = new Movie();
        Movie b = new Movie();
        Movie c = new Movie();
        Movie d = new Movie();
        Movie e = new Movie();
        Movie f = new Movie();
        Movie g = new Movie();

        movieRepo.save(a);
        movieRepo.save(b);
        movieRepo.save(c);
        movieRepo.save(d);
        movieRepo.save(e);
        movieRepo.save(f);
        movieRepo.save(g);





    }

    @Override
    public void run(ApplicationArguments args){
        //makeTestData();
    }





}
