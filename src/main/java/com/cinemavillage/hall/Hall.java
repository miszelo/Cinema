package com.cinemavillage.hall;

import com.cinemavillage.seat.Seat;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
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
