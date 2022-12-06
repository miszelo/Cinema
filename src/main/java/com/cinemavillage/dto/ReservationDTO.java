package com.cinemavillage.dto;

import com.cinemavillage.model.Seat;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationDTO {
    private List<Seat> seat;
    private String movieName;
    private LocalDateTime movieDate;

}
