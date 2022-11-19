package com.cinemavillage.service;

import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final MovieRepository movieRepository;
    @GetMapping("/book")
    public ModelAndView getMoviesByDate(LocalDate day) {
        ModelAndView model = new ModelAndView();
        movieRepository.findMoviesByDateOfScreening(day.atStartOfDay());
        return model;
    }

}