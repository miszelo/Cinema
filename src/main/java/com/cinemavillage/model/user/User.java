package com.cinemavillage.model.user;

import com.cinemavillage.model.Ticket;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

/**
 * Entity of user document in database
 * @author Michal Kawczak, Jakub Mikos
 */

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Field(name = "userID")
    private ObjectId id;

    @Field(name = "userEmail")
    private String email;

    @Field(name = "userPassword")
    private String password;

    @Field(name = "userRole")
    private Role role;

    @Field(name = "userTickets")
    private Set<Ticket> tickets;

}
