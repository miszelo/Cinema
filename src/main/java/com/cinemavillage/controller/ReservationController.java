package com.cinemavillage.controller;

import com.cinemavillage.dto.ReservationDTO;
import com.cinemavillage.model.Seat;
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
    @PostMapping("/reserve")
    public void reserve(@AuthenticationPrincipal UserDetailsImpl userDetails,
                        @RequestBody ReservationDTO reservationDTO) {
        reservationService.reserve(userDetails, reservationDTO);
    }
}
