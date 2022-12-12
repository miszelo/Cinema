package com.cinemavillage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "screening")
public class Screening {

    @Id
    @Field(name = "screeningID")
    private Long id;

    @Field(name = "screeningSeatState")
    private List<Seat> seatState;

    @Field(name = "hallScreeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "hallMovieName")
    private Movie movie;

    Screening(Long id, List<Seat> seatState, LocalDateTime screeningTime, Movie movie) {
        this.id = id;
        this.seatState = seatState;
        this.screeningTime = screeningTime;
        this.movie = movie;
    }

    public Screening(Long id, LocalDateTime screeningTime, Movie movie) {
        this.id = id;
        this.screeningTime = screeningTime;
        this.movie = movie;
        for (int row = 1; row < 15; row++) {
            for (int column = 1; column < 8; column++) {
                this.seatState.add(new Seat(row, column, false));
            }
        }
    }

}
