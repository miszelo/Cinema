package com.cinemavillage.repository;

import com.cinemavillage.model.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface ScreeningRepository extends MongoRepository<Screening, String> {

    List<Screening> findScreeningsByScreeningTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("{'screeningMovieName.movieTitle': ?0, 'screeningTime': {'$date': ?1}}")
    Screening findScreeningByMovieTitleAndScreeningTime(String movieTitle, LocalDateTime screeningTime);

}
