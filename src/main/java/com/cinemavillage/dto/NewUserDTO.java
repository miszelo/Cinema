package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Helper class for Data Transfer Object. This class is used only for easier communication with database
 * @author Michal Kawczak, Jakub Mikos
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDTO {
    private String userEmail;
    private String userPassword;

}
