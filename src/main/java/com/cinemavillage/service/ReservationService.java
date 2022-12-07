package com.cinemavillage.service;

import com.cinemavillage.model.Screening;
import com.cinemavillage.model.Movie;
import com.cinemavillage.repository.ScreeningRepository;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;

    public Screening getScreeningByMovieDate(Movie movie, LocalDateTime screeningTime) {
        return screeningRepository.findScreeningByMovieAndScreeningTime(movie, screeningTime);
    }

    public List<Screening> getHallByDate(LocalDateTime start, LocalDateTime end) {
        return screeningRepository.findScreeningsByScreeningTimeBetween(start, end);
    }

    public Movie getMovieById(ObjectId id){
        return movieRepository.findMoviesById(id);
    }
    public Movie getMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }
}
