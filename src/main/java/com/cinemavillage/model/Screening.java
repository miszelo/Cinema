package com.cinemavillage.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Document
public class Screening {

    @Id
    @Field(name = "screeningID")
    private Long id;

    @Field(name = "screeningSeatState")
    private ArrayList<Seat> seatState;

    @Field(name = "screeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "screeningMovieName")
    private Movie movie;

}
