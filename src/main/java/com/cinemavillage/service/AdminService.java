package com.cinemavillage.service;

import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;

    public ResponseEntity<Screening> addScreening(Screening screening) {
        if (screening.getMovie() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        screeningRepository.save(screening);
        return ResponseEntity.ok(screening);
    }

    public ResponseEntity<?> deleteScreening() {
        return null;
    }

    public ResponseEntity<?> updateScreening() {
        return null;
    }

    public ResponseEntity<Movie> addMovie(Movie movie) {
        if (movieRepository.existsByTitle(movie.getTitle())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }

    public ResponseEntity<?> deleteMovie() {
        return null;
    }

    public ResponseEntity<?> updateMovie() {
        return null;
    }

    public ResponseEntity<?> deleteUser() {
        return null;
    }

    public ResponseEntity<?> updateUsersRole() {
        return null;
    }

    public ResponseEntity<?> deleteTicket() {
        return null;
    }
}
