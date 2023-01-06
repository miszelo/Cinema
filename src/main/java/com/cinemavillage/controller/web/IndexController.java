package com.cinemavillage.controller.web;

import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class IndexController {
    private final static String HOME_PAGE = "homePage";
    private final static String CINEMA = "cinemaHallLayout";

    private final ScreeningRepository screeningRepository;

    private final MovieRepository movieRepository;

    @RequestMapping(value = {"/home/{date}", "/home", "/"})
    public String homePage(Model model, @PathVariable Optional<String> date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (date.isPresent()) {
            LocalDate localDate = LocalDate.parse(date.get(), formatter);
            model.addAttribute("date", localDate);
            List<Screening> testSeanse = screeningRepository.findScreeningsByScreeningTimeBetween(
                    LocalDateTime.of(localDate, LocalTime.parse("00:00:00")),
                    LocalDateTime.of(localDate, LocalTime.parse("23:59:00")));
            List<Screening> sortedScreenings = testSeanse.stream().sorted(Comparator.comparing(Screening::getScreeningTime)).toList();
            model.addAttribute("screenings", sortedScreenings);
        } else {
            LocalDate localDate = LocalDate.now();
            model.addAttribute("date", localDate);
            List<Screening> testSeanse = screeningRepository.findScreeningsByScreeningTimeBetween(LocalDateTime.of(localDate, LocalTime.parse("00:00:00")), LocalDateTime.of(localDate, LocalTime.parse("23:59:00")));
            List<Screening> sortedScreenings = testSeanse.stream().sorted(Comparator.comparing(Screening::getScreeningTime)).toList();
            model.addAttribute("screenings", sortedScreenings);
        }

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("today", LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        return HOME_PAGE;
    }

    @RequestMapping("/cinema")
    public String cinema() {
        return CINEMA;
    }
}
