package com.cinemavillage.controller.api;

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
public class ScreeningController {
    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;

    @GetMapping
    public Screening getHall() {

        return null;
    }

    @PostMapping("/screening/add")
    public ResponseEntity<?> addScreening(@RequestBody Screening screening) {
        System.out.println("\n\n" + screening.getScreeningTime() + "\n" + screening.getMovie().getTitle() + "\n\n" + screening.getMovie().getDuration());
        Screening newScreening = new Screening(screening.getScreeningTime(), screening.getMovie());
        screeningRepository.save(newScreening);
        return new ResponseEntity<>("Screening added.", HttpStatus.OK);
    }

}
