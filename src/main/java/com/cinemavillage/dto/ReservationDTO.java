package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private List<Integer> seats;
    private String movieDate;
    private String movieTitle;
}
