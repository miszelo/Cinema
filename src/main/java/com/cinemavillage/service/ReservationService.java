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
import java.util.ArrayList;
import java.util.List;

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

        System.out.println(user);
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

        System.out.println(ticket);
        ticketRepository.save(ticket);

        if (user.getTickets() == null) {
            List<Ticket> tickets = new ArrayList<>();
            user.setTickets(tickets);
        }
        user.getTickets().add(ticket);
        System.out.println(user);
        var currentSeats = screening.getSeatState();
        var reservedSeats = reservationDTO.getSeats();

        for (Integer seatNumber : reservedSeats) {
            currentSeats.get(seatNumber - 1).setTaken(true);
        }
        screening.setSeatState(currentSeats);
        System.out.println("Screening " + screening);
        System.out.println("User " + user);
        System.out.println("ticket " + ticket);
        screeningRepository.save(screening);
        userRepository.save(user);
    }
}
