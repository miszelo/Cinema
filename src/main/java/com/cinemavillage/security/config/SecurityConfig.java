package com.cinemavillage.security.config;

import com.cinemavillage.model.user.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests(auth -> {
                    //auth.antMatchers("/").hasAuthority(Role.USER.name());
                    auth.antMatchers("/register").permitAll();
                    //auth.antMatchers("/home").hasAuthority(Role.USER.name());
                    //auth.antMatchers("/home/**").hasAuthority(Role.USER.name());
                    auth.antMatchers("/book").hasAuthority(Role.USER.name());
                    auth.antMatchers("/movie/add").hasAuthority(Role.ADMIN.name());
                })
                .formLogin()
                    .defaultSuccessUrl("/home", true);
        return http.build();
    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
