package com.bio.hawaii_bio.security;

import com.bio.hawaii_bio.entity.User;
import com.bio.hawaii_bio.repo.UserRepo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    UserRepo userRepo;

    public UserDetailsServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepo.findById(username);
        return optionalUser.map(UserDetailsImp::new).orElseThrow(() -> new BadCredentialsException(""));
    }

}
