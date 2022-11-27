package com.cinemavillage.model.hall;

import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.model.seat.Seat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Hall {
    @Id
    private Long id;
    private ArrayList<Seat> seatState;
    private LocalDateTime screeningTime;
    private Movie movie;

}
