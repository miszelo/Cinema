package com.cinemavillage.service;

import com.cinemavillage.dto.ReservationDTO;
import com.cinemavillage.exception.MovieNotFoundException;
import com.cinemavillage.exception.ScreeningNotFoundException;
import com.cinemavillage.exception.user.UserNotFoundException;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> reserve(UserDetailsImpl userDetails, ReservationDTO reservationDTO) {
        if (userDetails == null) {
            throw new UserNotFoundException();
        }
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);

        Movie movie = movieRepository.findMovieByTitle(reservationDTO.getMovieTitle())
                .orElseThrow(MovieNotFoundException::new);

        LocalDateTime screeningTime = LocalDateTime.parse(reservationDTO.getMovieDate());
        Screening screening = screeningRepository.findScreeningByMovieTitleAndScreeningTime(
                reservationDTO.getMovieTitle(),
                screeningTime)
                .orElseThrow(ScreeningNotFoundException::new);

        Ticket ticket = Ticket.builder()
                .userEmail(user.getEmail())
                .movieName(movie.getTitle())
                .movieDate(screeningTime)
                .seats(reservationDTO.getSeats())
                .ticketCode((user.getEmail().hashCode()
                        + screeningTime.toString().hashCode()
                        + new Date().toString())
                        .replace(" ","")
                        .replace("-","")
                        .replace(":","")
                        .replaceAll("CET2023","").toUpperCase())
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
        return ResponseEntity.ok("Dear " + user.getEmail() + "\nYour ticket code: \n" + ticket.getTicketCode());
    }
}
