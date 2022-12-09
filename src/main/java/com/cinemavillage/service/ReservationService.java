package com.cinemavillage.service;

import com.cinemavillage.dto.ReservationDTO;
import com.cinemavillage.exception.userException.UserNotFoundException;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.model.Ticket;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import com.cinemavillage.repository.TicketRepository;
import com.cinemavillage.repository.UserRepository;
import com.cinemavillage.security.config.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public Screening getScreeningByMovieDate(Movie movie, LocalDateTime screeningTime) {
        return screeningRepository.findScreeningByMovieAndScreeningTime(movie, screeningTime);
    }

    public List<Screening> getHallByDate(LocalDateTime start, LocalDateTime end) {
        return screeningRepository.findScreeningsByScreeningTimeBetween(start, end);
    }

    public Movie getMovieById(ObjectId id) {
        return movieRepository.findMoviesById(id);
    }

    public void reserve(UserDetailsImpl userDetails, ReservationDTO reservationDTO) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);
        Ticket ticket = Ticket.builder()
                .user(user)
                .movie(movieRepository.findMovieByTitle(reservationDTO.getMovieTitle()))
                .build();
        user.getTickets().add(ticket);
        userRepository.save(user);
        ticketRepository.save(ticket);

        //TODO update hall seats
        //TODO reservationDTO
        //TODO ticket

    }
}
