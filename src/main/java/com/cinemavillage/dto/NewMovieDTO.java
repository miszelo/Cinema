package com.cinemavillage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewMovieDTO {
    private String movieTitle;
    private int movieDuration;
    private String movieDescription;
}
