package com.cinemavillage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "movie")
public class Movie {

    @Id
    @Field("movieID")
    Long id;

    @Field("movieTitle")
    String title;

    @Field("movieDuration")
    int duration;

    @Field("movieDescription")
    String description;

    Movie(Long id, String title, int duration, String description) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

}
