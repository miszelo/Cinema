package com.cinemavillage.controller;

import com.cinemavillage.dto.ReservationDTO;
import com.cinemavillage.security.config.UserDetailsImpl;
import com.cinemavillage.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class ReservationController {

    private final ReservationService reservationService;

    @PutMapping("/reserve")
    public void reserve(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody ReservationDTO reservationDTO) {
        reservationService.reserve(userDetails, reservationDTO);

    }


}
