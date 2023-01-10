package com.cinemavillage.model;

import com.cinemavillage.model.user.User;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @Field(name = "ticketUser")
    @DBRef
    private User user;

    @Field(name = "ticketMovie")
    @DBRef
    private Movie movie;

    @Field(name = "ticketScreening")
    @DBRef
    private Screening screening;
}
