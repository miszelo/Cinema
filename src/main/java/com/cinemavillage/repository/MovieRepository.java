package com.cinemavillage.repository;

import com.cinemavillage.model.movie.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, LocalDateTime> {

    Movie findMovieByDateOfScreening(LocalDateTime date);
    List<Movie> findMoviesByDateOfScreening(LocalDateTime date);
}
