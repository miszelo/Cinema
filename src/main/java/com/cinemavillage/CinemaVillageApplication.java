package com.cinemavillage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Cinema simulator, users can book the tickets for the movie they pick via button with screening hour on it. Then they pick the seats.
 * @author Mikos Jakub, Kawczak Michał
 * @see SpringApplication
 */
@SpringBootApplication
public class CinemaVillageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CinemaVillageApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(CinemaVillageApplication.class, args);

    }

}
