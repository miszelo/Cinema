package com.cinemavillage.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userID;

    private String userEmail;

    private String userPassword;

    private Role role;

}
