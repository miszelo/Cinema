package com.cinemavillage.controller.web;

import com.cinemavillage.exception.ScreeningNotFoundException;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = {"/home/{date}", "/home", "/"}, method = RequestMethod.GET)
    public String homePage(Model model, @PathVariable Optional<String> date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        model.addAttribute("noScreenings", false);
        LocalDate localDate;
        if (date.isPresent()) {
            localDate = LocalDate.parse(date.get(), formatter);
        } else {
            localDate = LocalDate.now();
        }
        addDateToModel(model, localDate);

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        model.addAttribute("today", LocalDateTime.now().truncatedTo(ChronoUnit.DAYS));
        return HOME_PAGE;
    }

    private void addDateToModel(Model model, LocalDate localDate) {
        model.addAttribute("date", localDate);
        List<Screening> screenings = screeningRepository.findScreeningsByScreeningTimeBetween(
                        LocalDateTime.of(localDate, LocalTime.parse("00:00:00")),
                        LocalDateTime.of(localDate, LocalTime.parse("23:59:00")))
                .stream()
                .sorted(Comparator.comparing(Screening::getScreeningTime))
                .toList();
        if (screenings.isEmpty()) {
            model.addAttribute("noScreenings", true);
        }
        model.addAttribute("screenings", screenings);
    }

    @RequestMapping(value = {"/book/{date}/{movieTitle}"}, method = RequestMethod.GET)
    public String getSeatView(Model model, @PathVariable String date, @PathVariable String movieTitle) {
        LocalDateTime screeningTime = LocalDateTime.parse(date);
        Screening screening = screeningRepository.findScreeningByMovieTitleAndScreeningTime(movieTitle, screeningTime)
                .orElseThrow(ScreeningNotFoundException::new);
        model.addAttribute("seatState", screening.getSeatState());
        model.addAttribute("date", date);
        model.addAttribute("day", date.split("T")[0]);
        model.addAttribute("hour", date.split("T")[1]);
        model.addAttribute("duration", screening.getMovie().getDuration());
        model.addAttribute("description", screening.getMovie().getDescription());
        model.addAttribute("movieTitle", movieTitle);
        return CINEMA;
    }
}
