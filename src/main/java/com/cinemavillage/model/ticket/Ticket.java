package com.cinemavillage.model.ticket;

import com.cinemavillage.model.hall.Hall;
import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @Field(name = "ticketID")
    private String ID;

    @Field(name = "ticketUser")
    private User user;

    @Field(name = "ticketMovie")
    private Movie movie;

    @Field(name = "ticketHall")
    private Hall hall;
}
