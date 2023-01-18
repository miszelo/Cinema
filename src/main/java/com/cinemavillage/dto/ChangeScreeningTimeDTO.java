package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeScreeningTimeDTO {
    private String movieTitle;
    private String currentScreeningDate;
    private String newScreeningDate;
}
