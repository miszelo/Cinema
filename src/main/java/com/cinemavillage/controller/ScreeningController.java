package com.cinemavillage.controller;

import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    //looking for a convenient way to add screenings, working, need some tweaks
    @GetMapping("/add")
    public String addScreening(){
        System.out.println("Aaaaaa");
        Screening screening = new Screening(0L, LocalDateTime.of(2022,12,13,12,0), movieRepository.findMovieByTitle("HARRY POTTER I KAMIEŃ FILOZOFICZNY"));
        System.out.println(screening.toString());
        screeningRepository.save(screening);
        return "homePage";
    }

}
