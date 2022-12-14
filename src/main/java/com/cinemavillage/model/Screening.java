package com.cinemavillage.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "screening")
@Data
@Builder
public class Screening {

    @Id
    @Field(name = "screeningID")
    private Long id;

    @Field(name = "screeningSeatState")
    private List<Seat> seatState;

    @Field(name = "screeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "screeningMovieName")
    private Movie movie;

    public Screening(Long id, List<Seat> seatState, LocalDateTime screeningTime, Movie movie) {
        this.id = id;
        this.seatState = seatState;
        this.screeningTime = screeningTime;
        this.movie = movie;
    }

    public Screening(Long id, LocalDateTime screeningTime, Movie movie) {
        this.id = id;
        this.screeningTime = screeningTime;
        this.movie = movie;
        this.seatState = new ArrayList<Seat>();
        setNewSeatState();
    }
    private void setNewSeatState() {
        for (int row = 1; row < 8; row++) {
            for (int column = 1; column < 15; column++) {
                this.seatState.add(new Seat(row, column, false));
            }
        }
    }

}
