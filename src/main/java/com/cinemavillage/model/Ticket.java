package com.cinemavillage.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @Field(name = "ticketID")
    private ObjectId id;

    @Field(name = "ticketCode")
    private String ticketCode;

    @Field(name = "userEmail")
    private String userEmail;

    @Field(name = "movieName")
    private String movieName;

    @Field(name = "movieDate")
    private LocalDateTime movieDate;

    @Field(name = "seats")
    private List<Integer> seats;
}
