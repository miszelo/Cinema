package com.cinemavillage.repository;

import com.cinemavillage.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Movie findMoviesById(ObjectId id);

    List<Movie> findAll();

    Movie findMovieByTitle(String title);
}
