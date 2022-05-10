package com.bio.hawaii_bio.config;

import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.entity.Role;
import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.repo.MovieRepo;
import com.bio.hawaii_bio.repo.UserRepo;
import com.bio.hawaii_bio.service.MovieService;
import com.bio.hawaii_bio.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    MovieRepo movieRepo;
    UserRepo userRepo;

    public MakeTestData(MovieRepo movieRepo, UserRepo userRepo) {
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;

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

        // User test data
        User adm = new User(12345678, "adm", "a", "aa", "a@mail.com",
                "1234", "street", "city", 2000, Role.ADMIN);
        User emp = new User(23456789, "emp", "b", "bb", "b@mail.com",
                "1234", "street", "city", 2000, Role.EMPLOYEE);
        User mem = new User(34567891, "mem", "c", "cc", "c@mail.com",
                "1234", Role.MEMBER);
        User cus = new User(45678912, Role.CUSTOMER);

        userRepo.save(adm);
        userRepo.save(emp);
        userRepo.save(mem);
        userRepo.save(cus);


    }

    @Override
    public void run(ApplicationArguments args){
        //movieRepo.deleteAll();
        //makeTestData();
    }





}
