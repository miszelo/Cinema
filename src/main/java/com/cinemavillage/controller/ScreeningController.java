package com.cinemavillage.controller;

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
    //currently not working
    @PutMapping("/screening/add")
    public ResponseEntity<?> addScreening(@RequestBody Screening screening){
        //Screening newScreening = new Screening();
        //screeningRepository.save(newScreening);
        return new ResponseEntity<>("Screening added.",HttpStatus.OK);
    }

}
