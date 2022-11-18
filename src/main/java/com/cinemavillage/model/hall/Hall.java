package com.cinemavillage.model.hall;

import com.cinemavillage.model.seat.Seat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
public class Hall {
    @Id
    private Long id;
    private ArrayList<Seat> Seats;
    private LocalDateTime screeningTime;
    private String movieName;
}
