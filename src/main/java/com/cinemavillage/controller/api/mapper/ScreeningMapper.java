package com.cinemavillage.controller.api.mapper;

import com.cinemavillage.dto.NewScreeningDTO;
import com.cinemavillage.exception.MovieNotFoundException;
import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.util.ScreeningUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class ScreeningMapper {

    private final MovieRepository movieRepository;

    public Screening mapScreeningDTOToScreening(NewScreeningDTO newScreeningDTO) {
        return Screening.builder()
                .screeningTime(LocalDateTime.parse(newScreeningDTO.getScreeningDate()))
                .movie(movieRepository.findMovieByTitle(newScreeningDTO.getMovieTitle())
                        .orElseThrow(MovieNotFoundException::new))
                .seatState(ScreeningUtil.setNewSeatState(new ArrayList<>()))
                .build();
    }
}
