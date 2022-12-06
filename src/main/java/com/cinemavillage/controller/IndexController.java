package com.cinemavillage.controller;

import com.cinemavillage.model.Movie;
import com.cinemavillage.repository.HallRepository;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class IndexController {
    private final static String HOME_PAGE = "homePage";
    private final static String CINEMA = "cinemaHallLayout";

    private final HallRepository hallRepository;

    private final MovieRepository movieRepository;

    @RequestMapping("/home/{date}")
    public String homePageLogged(Model model, @PathVariable Optional<String> date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        if (date.isPresent()) {
            LocalDate localDate = LocalDate.parse(date.toString() ,formatter);
        } else {
            LocalDate localDate = LocalDate.now();
        }
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("today", LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        //TODO
        //do modelu dodać coś na podstawie czego można mieć godziny seansów, tj tytuł filmu i date
        //czyli dla kazdego tytulu filmu i danej daty znalezc godziny seansów ktore powinny zostac zawarte w modelu
        return HOME_PAGE;
    }

    @RequestMapping("/cinema")
    public String cinema() {
        return CINEMA;
    }
}
