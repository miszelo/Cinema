package com.cinemavillage.model.user;

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
public class User {

    @Id
    @Field(name="userID")
    private String ID;

    @Field(name="userEmail")
    private String email;

    @Field(name="userPassword")
    private String password;

    @Field(name="userRole")
    private Role role;

}
