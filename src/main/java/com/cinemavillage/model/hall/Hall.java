package com.cinemavillage.model.hall;

import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.model.seat.Seat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
public class Hall {

    @Id
    @Field(name = "hallID")
    private Long id;

    @Field(name = "hallSeatState")
    private ArrayList<Seat> seatState;

    @Field(name = "hallScreeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "hallMovieName")
    private Movie movie;

}
