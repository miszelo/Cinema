package com.cinemavillage.controller;

import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;

    @PutMapping("/movie/add")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        Movie newMovie = new Movie(movie.getTitle(),movie.getDuration(), movie.getDescription());
        movieRepository.save(newMovie);
        return new ResponseEntity<>("Movie added", HttpStatus.OK);
    }

}
