package com.cinemavillage.security.config;

import com.cinemavillage.model.user.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration of security in application
 *
 * @author Michal Kawczak, Jakub Mikos
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests((auth) -> {
                    auth.antMatchers("/register").permitAll();
                    auth.antMatchers("/home/**", "/").permitAll();
                    auth.antMatchers("/admin/**").hasAuthority(Role.ADMIN.name());
                    auth.antMatchers("/user/**").hasAuthority(Role.USER.name());
                    auth.antMatchers("/book/reserve").authenticated();
                })
                .formLogin((form) -> form
                        .defaultSuccessUrl("/home", true)
                        .permitAll())
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll();
        return http.build();
    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
