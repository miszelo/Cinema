package com.cinemavillage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document
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

}
