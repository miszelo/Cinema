package com.cinemavillage.model.movie;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Movie {

    @Id
    String id;

    String title;

    int duration;

    String description;

}
