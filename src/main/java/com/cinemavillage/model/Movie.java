package com.cinemavillage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class Movie {

    @Id
    @Field("movieID")
    String id;

    @Field("movieTitle")
    String title;

    @Field("movieDuration")
    int duration;

    @Field("movieDescription")
    String description;

}
