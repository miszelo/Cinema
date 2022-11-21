package com.cinemavillage.model.movie;

import com.cinemavillage.model.hall.Hall;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
public class Movie {

    @Id
    String id;

    String title;

    int duration;

    List<Hall> seatState;

    LocalDateTime dateOfScreening;

}
