package com.cinemavillage.controller;

import com.cinemavillage.model.hall.Hall;
import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.repository.HallRepository;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {

    private final static String HOME_PAGE = "home_page";
    private final static String HOME_PAGE_LOGGED = "home_page_logged";
    private final static String CINEMA = "cinemaHallLayout";

    private final HallRepository hallRepository;

    private final MovieRepository movieRepository;

    @RequestMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView(HOME_PAGE);
    }

    @RequestMapping("/home")
    public String homePageLogged(Model model) {

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("today", LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        return HOME_PAGE_LOGGED;
    }

    @RequestMapping("/cinema")
    public String cinema() {
        return CINEMA;
    }
}
