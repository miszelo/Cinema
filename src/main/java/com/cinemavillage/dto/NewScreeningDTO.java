package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewScreeningDTO {
    private String movieTitle;
    private String screeningDate;
}
