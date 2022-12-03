package com.cinemavillage.service;

import com.cinemavillage.model.hall.Hall;
import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.model.seat.Seat;
import com.cinemavillage.repository.HallRepository;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final HallRepository hallRepository;
    private final MovieRepository movieRepository;

    public Hall getHallByMovieDate(Movie movie, LocalDateTime screeningTime) {
        return hallRepository.findHallByMovieAndScreeningTime(movie, screeningTime);
    }

    public List<Hall> getHallByDate(LocalDateTime start, LocalDateTime end) {
        return hallRepository.findHallsByScreeningTimeBetween(start, end);
    }

    public Movie getMovieById(ObjectId id){
        return movieRepository.findMoviesById();
    }
}
