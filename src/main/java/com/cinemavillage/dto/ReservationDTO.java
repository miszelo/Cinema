package com.cinemavillage.dto;

import com.cinemavillage.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private List<Seat> seats;
    private String movieTitle;
    private LocalDateTime movieDate;

}
