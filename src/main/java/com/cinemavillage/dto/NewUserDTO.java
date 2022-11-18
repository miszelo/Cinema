package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {

    private String userEmail;

    private String userPassword;

}
