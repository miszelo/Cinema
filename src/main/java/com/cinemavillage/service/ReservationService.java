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

        Movie movie = movieRepository.findMovieByTitle(reservationDTO.getMovieTitle());

        Ticket ticket = Ticket.builder()
                .user(user)
                .movie(movie)
                .build();

        Screening screening = screeningRepository.findScreeningByMovieAndScreeningTime(movie, reservationDTO.getMovieDate());

        user.getTickets().add(ticket);
        var currentSeats = screening.getSeatState();
        var reservedSeats = reservationDTO.getSeats();
        for (int i = 0; i < currentSeats.size(); i++) {
            if ((currentSeats.get(i).getRow() == reservedSeats.get(i).getRow() &&
                    currentSeats.get(i).getColumn() == reservedSeats.get(i).getColumn()) &&
                    !currentSeats.get(i).isTaken() && reservedSeats.get(i).isTaken()) {
                currentSeats.get(i).setTaken(true);
            }
        }
        screeningRepository.save(screening);
        userRepository.save(user);
        ticketRepository.save(ticket);

        //TODO update hall currentSeats
        //TODO reservationDTO
        //TODO ticket

    }
}
