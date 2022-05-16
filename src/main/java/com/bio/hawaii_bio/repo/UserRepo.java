package com.bio.hawaii_bio.repo;

import com.bio.hawaii_bio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    @Query("select (count(u) > 0) from User u where u.email = :email")
    boolean emailExist(String email);

    Optional<User> findByUsername(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
