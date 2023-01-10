package com.cinemavillage.repository;

import com.cinemavillage.model.Screening;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ScreeningRepository extends MongoRepository<Screening, ObjectId> {

    List<Screening> findScreeningsByScreeningTimeBetween(LocalDateTime start, LocalDateTime end);

    @Query("{'screeningMovieName.movieTitle': ?0, 'screeningTime': {'$date': ?1}}")
    Screening findScreeningByMovieTitleAndScreeningTime(String movieTitle, LocalDateTime screeningTime);

}
