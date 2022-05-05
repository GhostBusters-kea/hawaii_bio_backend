package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean emailExist(String email);

    @Query("select (count(u) > 0) from User u where u.username = :username")
    boolean usernameExist(String username);
}
