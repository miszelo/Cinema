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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public void reserve(UserDetailsImpl userDetails, ReservationDTO reservationDTO) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);

        Movie movie = movieRepository.findMovieByTitle(reservationDTO.getMovieTitle());

        LocalDateTime screeningTime = LocalDateTime.parse(reservationDTO.getMovieDate());
        Screening screening = screeningRepository.findScreeningByMovieTitleAndScreeningTime(
                reservationDTO.getMovieTitle(),
                screeningTime);

        Ticket ticket = Ticket.builder()
                .user(user)
                .movie(movie)
                .screening(screening)
                .build();

        if (user.getTickets() == null) {
            Set<Ticket> tickets = new HashSet<>();
            user.setTickets(tickets);
        }
        user.getTickets().add(ticket);

        var currentSeats = screening.getSeatState();
        var reservedSeats = reservationDTO.getSeats();

        for (Integer seatNumber : reservedSeats) {
            currentSeats.get(seatNumber - 1).setTaken(true);
        }
        screening.setSeatState(currentSeats);
        screeningRepository.save(screening);
        ticketRepository.save(ticket);
        userRepository.save(user);
    }
}
