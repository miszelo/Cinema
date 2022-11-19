package com.cinemavillage.service;

import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

//    @GetMapping("/book")
//    public ModelAndView getMoviesByDate() {
//        System.out.println("EEEEEEE");
//        ModelAndView model = new ModelAndView();
//        Movie movie = movieRepository.findMoviesById("6378ae0fdc32216566ac95fd");
//        model.addObject("movies", movie);
//        return model;
//    }

}
