package com.cinemavillage.controller.api;

import com.cinemavillage.model.Movie;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @PutMapping("/movie/add")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        Movie newMovie = new Movie(movie.getTitle(), movie.getDuration(), movie.getDescription());
        movieRepository.save(newMovie);
        return new ResponseEntity<>("Movie added", HttpStatus.OK);
    }

}
