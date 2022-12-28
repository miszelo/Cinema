package com.cinemavillage.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "movie")
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

    public Movie(String title, int duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
    }
}
