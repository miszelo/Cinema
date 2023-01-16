package com.cinemavillage.controller.api.mapper;

import com.cinemavillage.dto.NewMovieDTO;
import com.cinemavillage.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mapper class to map DTO into entity or entity into DTO
 * @author Michal Kawczak, Jakub Mikos
 */

@Component
@AllArgsConstructor
public class MovieMapper {

    public Movie mapMovieDTOToMovie(NewMovieDTO newMovieDTO) {
        return Movie.builder()
                .title(newMovieDTO.getMovieTitle())
                .description(newMovieDTO.getMovieDescription())
                .duration(newMovieDTO.getMovieDuration())
                .build();
    }
}
