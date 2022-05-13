package com.bio.hawaii_bio.config;

import com.bio.hawaii_bio.entity.Category;
import com.bio.hawaii_bio.entity.Movie;
import com.bio.hawaii_bio.entity.Performance;
import com.bio.hawaii_bio.repo.MovieRepo;
import com.bio.hawaii_bio.repo.PerformanceRepo;
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

import java.time.LocalDateTime;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {

    MovieRepo movieRepo;
    PerformanceRepo performanceRepo;
    UserRepo userRepo;

    public MakeTestData(MovieRepo movieRepo, PerformanceRepo performanceRepo,UserRepo userRepo) {
        this.movieRepo = movieRepo;
       this.performanceRepo = performanceRepo;
      this.userRepo = userRepo;
    }

    public void makeTestData(){
        Movie a = new Movie("Terminator II", Category.ACTION, 120,"Fremtidsrobotfilm",
                16,"https://m.media-amazon.com/images/M/MV5BMGU2NzRmZjUtOGUxYS00ZjdjLWEwZWItY2NlM2JhNjkxNTFmXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg");
        Movie b = new Movie("Rosemary's Baby", Category.HORROR, 124,"Uhyggelig film", 16,
                "https://m.media-amazon.com/images/M/MV5BMTQ3OTI5NzIzNF5BMl5BanBnXkFtZTgwNTc4NTQ0MTE@._V1_.jpg"
                );
        Movie c = new Movie("Jurassic Park", Category.SCIENCE_FICTION, 128, "En film om dinosaurs",15,
                "https://flxt.tmsimg.com/assets/p14812_p_v11_ba.jpg");
        Movie d = new Movie("Harry Potter", Category.ADVENTURE, 110,"En film om en troldmand",8,"https://sfanytime-images-prod.secure.footprint.net/COVERM/COVERM_991c1624-cce6-48e5-ae08-ff5f7f4b492d_da.jpg?w=375&fm=pjpg&s=6cf9015604a0d934dd1aa11f8f70c33e");
        Movie e = new Movie("Hot Shots!", Category.COMEDY, 118,"En film om jægerpiloter",12,
                "https://m.media-amazon.com/images/M/MV5BNzgxNmI1ODItZWZlYy00ZjE0LWIwYjgtMTk2MzU0MjhkOWIzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg");
        Movie f = new Movie("Apocalypse Now", Category.ACTION,133,"En film om Vietnamkrigen",18,
                "https://m.media-amazon.com/images/M/MV5BMDdhODg0MjYtYzBiOS00ZmI5LWEwZGYtZDEyNDU4MmQyNzFkXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg");
        Movie g = new Movie("Pretty Woman", Category.ROMANCE, 113,"En film om kærlighed",12,
                "https://m.media-amazon.com/images/M/MV5BMTMwNTA5ODAxM15BMl5BanBnXkFtZTYwNTQwODU5._V1_.jpg");
        movieRepo.save(a);
        movieRepo.save(b);
        movieRepo.save(c);
        movieRepo.save(d);
        movieRepo.save(e);
        movieRepo.save(f);
        movieRepo.save(g);


        Performance p1 = new Performance();
        Performance p = new Performance();
        Performance p2 = new Performance();
        Performance p3 = new Performance();
        Performance p4 = new Performance();
        Performance p5 = new Performance();
        Performance p6 = new Performance();
        Performance p7 = new Performance();
        Performance p8 = new Performance();
        Performance p9 = new Performance();

        performanceRepo.save(p1);
        performanceRepo.save(p);
        performanceRepo.save(p2);
        performanceRepo.save(p3);
        performanceRepo.save(p4);
        performanceRepo.save(p5);
        performanceRepo.save(p6);
        performanceRepo.save(p7);
        performanceRepo.save(p8);
        performanceRepo.save(p9);

        /*
        p.setMovie(a);
        p1.setMovie(a);
        p2.setMovie(a);
        p3.setMovie(a);
        p4.setMovie(b);
        p5.setMovie(b);


        a.addPerformance(p);
        a.addPerformance(p1);
        a.addPerformance(p2);
        a.addPerformance(p3);
        b.addPerformance(p4);
        b.addPerformance(p5);

         */





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
        movieRepo.deleteAll();
        makeTestData();
    }





}
