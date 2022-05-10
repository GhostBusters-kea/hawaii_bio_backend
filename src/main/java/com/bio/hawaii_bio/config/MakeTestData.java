package com.bio.hawaii_bio.config;

import com.bio.hawaii_bio.entity.Category;
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
        Movie a = new Movie("Terminator II", Category.ACTION, 120,"Fremtidsrobotfilm", 16);
        Movie b = new Movie("Rosemary's Baby", Category.HORROR, 124,"Uhyggelig film", 16);
        Movie c = new Movie("Jurassic Park", Category.SCIENCE_FICTION, 128, "En film om dinosaurs",15);
        Movie d = new Movie("Harry Potter", Category.ADVENTURE, 110,"En film om en troldmand",8);
        Movie e = new Movie("Hot Shots!", Category.COMEDY, 118,"En film om jægerpiloter",12);
        Movie f = new Movie("Apocalypse Now", Category.ACTION,133,"En film om Vietnamkrigen",18);
        Movie g = new Movie("Pretty Woman", Category.ROMANCE, 113,"En film om kærlighed",12);
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
        //movieRepo.deleteAll();
        //makeTestData();
    }





}
