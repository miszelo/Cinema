package com.cinemavillage.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "movie")
public class Movie {

    @Id
    @Field("movieID")
    private ObjectId id;

    @Field("movieTitle")
    private String title;

    @Field("movieDuration")
    private int duration;

    @Field("movieDescription")
    private String description;

}
