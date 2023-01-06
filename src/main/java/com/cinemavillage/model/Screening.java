package com.cinemavillage.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "screening")
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Screening {

    @Id
    @Field(name = "screeningID")
    private String id;

    @Field(name = "screeningSeatState")
    private List<Seat> seatState;

    @Field(name = "screeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "screeningMovieName")
    private Movie movie;

    public Screening(LocalDateTime screeningTime, Movie movie) {
        this.screeningTime = screeningTime;
        this.movie = movie;
        this.seatState = new ArrayList<>();
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
