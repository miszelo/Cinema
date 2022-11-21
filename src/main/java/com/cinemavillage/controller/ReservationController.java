package com.cinemavillage.controller;

import com.cinemavillage.model.hall.Hall;
import com.cinemavillage.service.ReservationService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Controller
@AllArgsConstructor
@RequestMapping("/book")
public class ReservationController {

    private final ReservationService reservationService;




    @GetMapping("/screening/{movieId}/{date}")
        public String getHallView(Model model, @PathVariable LocalDateTime date, @PathVariable ObjectId movieId, HttpServletRequest request) {
            //model.addAttribute("hall",reservationService.getHallByDate(LocalDateTime.of(date.toLocalDate(), LocalTime.MIDNIGHT), LocalDateTime.of(date.toLocalDate().plusDays(1),LocalTime.MIDNIGHT)));
        model.addAttribute("seatState", reservationService.getHallByMovieDate(reservationService.getMovieById(movieId),date));
        return "cinemaHallLayout";
    }
}
