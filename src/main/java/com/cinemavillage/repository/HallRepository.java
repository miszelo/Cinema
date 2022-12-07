package com.cinemavillage.repository;

import com.cinemavillage.model.Hall;
import com.cinemavillage.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface HallRepository extends MongoRepository<Hall, String> {

    Hall findFirstById();
    Hall findHallByMovie();

    Hall findHallByMovieAndScreeningTime(Movie movie, LocalDateTime screeningTime);

    //start - 00:00 at a X day, end - 00:00 at a X+1 day
    List<Hall> findHallsByScreeningTimeBetween(LocalDateTime start, LocalDateTime end);

}
