package com.cinemavillage.controller.api;

import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ScreeningController {
    private final ScreeningRepository screeningRepository;

    @GetMapping
    public Screening getHall() {

        return null;
    }

    @PostMapping("/screening/add")
    public ResponseEntity<?> addScreening(@RequestBody Screening screening) {
        Screening newScreening = new Screening(screening.getScreeningTime(), screening.getMovie());
        screeningRepository.save(newScreening);
        return new ResponseEntity<>("Screening added.", HttpStatus.OK);
    }

}
