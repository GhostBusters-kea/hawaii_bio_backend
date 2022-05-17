package com.bio.hawaii_bio.security.config;

import com.bio.hawaii_bio.repo.UserRepo;
import com.bio.hawaii_bio.security.UserDetailsServiceImp;
import com.bio.hawaii_bio.security.UserWithPassword;
import com.bio.hawaii_bio.security.jwt.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity(debug = false)
@EnableGlobalMethodSecurity(
        //securedEnabled = true,
        jsr250Enabled = true // enables @RolesAllowed annotation.
        //prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserRepo userRepo;
  private final UserDetailsServiceImp userDetailsService;
  private final JwtTokenFilter jwtTokenFilter;

  public SecurityConfig(UserRepo userRepository, UserDetailsServiceImp userDetailsService, JwtTokenFilter jwtTokenFilter) {
    this.userRepo = userRepository;
    this.userDetailsService = userDetailsService;
    this.jwtTokenFilter = jwtTokenFilter;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return UserWithPassword.getPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Enable CORS and disable CSRF
    http.cors().and().csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .exceptionHandling()
            .authenticationEntryPoint(
                    (request, response, ex) -> {
                      response.sendError(
                              HttpServletResponse.SC_UNAUTHORIZED,
                              ex.getMessage()
                      );
                    }
            )
            .and()
            .authorizeRequests()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/error").permitAll()
            .antMatchers(HttpMethod.GET, "/api/").permitAll()
            .antMatchers(HttpMethod.GET, "/api/movies/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/performance/**").permitAll()
            // All other endpoints are private
            .anyRequest().authenticated();
            //.anyRequest().permitAll();  //Disable Security
    http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
