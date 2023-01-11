package com.cinemavillage.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "screening")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Screening {

    @Id
    @Field(name = "screeningID")
    private ObjectId id;

    @Field(name = "screeningSeatState")
    private List<Seat> seatState;

    @Field(name = "screeningTime")
    private LocalDateTime screeningTime;

    @Field(name = "screeningMovieName")
    private Movie movie;

}
