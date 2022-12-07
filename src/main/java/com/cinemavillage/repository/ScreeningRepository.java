package com.cinemavillage.repository;

import com.cinemavillage.model.Screening;
import com.cinemavillage.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface ScreeningRepository extends MongoRepository<Screening, String> {

    Screening findFirstById(ObjectId id);
    Screening findHallByMovie(Movie movie);

    Screening findScreeningByMovieAndScreeningTime(Movie movie, LocalDateTime screeningTime);

    //start - 00:00 at a X day, end - 00:00 at a X+1 day
    List<Screening> findScreeningsByScreeningTimeBetween(LocalDateTime start, LocalDateTime end);

}
