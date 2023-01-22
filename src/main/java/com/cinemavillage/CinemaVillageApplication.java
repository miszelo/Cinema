package com.cinemavillage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Cinema simulator, users can book the tickets for the movie they pick via button with screening hour on it. Then they pick the seats.
 *
 * @author Mikos Jakub, Kawczak Michał
 * @see SpringApplication
 */
@SpringBootApplication
public class CinemaVillageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaVillageApplication.class, args);

    }

}
