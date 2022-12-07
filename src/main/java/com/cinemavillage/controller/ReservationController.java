package com.cinemavillage.controller;

import com.cinemavillage.dto.ReservationDTO;
import com.cinemavillage.security.config.UserDetailsImpl;
import com.cinemavillage.service.ReservationService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/book")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/screening/{movieId}/{date}")
        public String getHallView(Model model, @PathVariable LocalDateTime date, @PathVariable String movieTitle, HttpServletRequest request) {
            //model.addAttribute("hall",reservationService.getHallByDate(LocalDateTime.of(date.toLocalDate(), LocalTime.MIDNIGHT), LocalDateTime.of(date.toLocalDate().plusDays(1),LocalTime.MIDNIGHT)));
        model.addAttribute("seatState", reservationService.getScreeningByMovieDate(reservationService.getMovieByTitle(movieTitle),date));
        return "cinemaHallLayout";
    }

    @PostMapping
    public void reserve(@AuthenticationPrincipal UserDetailsImpl userDetails,
                        @RequestBody ReservationDTO reservationDTO) {

    }
    //TODO
    // FIND GODZINA BY DZIEN I FILMTYTUŁ MA ZWRACAĆ  ArrayList<LocalTime>
}
