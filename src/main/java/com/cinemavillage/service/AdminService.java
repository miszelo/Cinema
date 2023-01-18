package com.cinemavillage.service;

import com.cinemavillage.dto.ChangeScreeningTimeDTO;
import com.cinemavillage.exception.TicketsNotFoundException;
import com.cinemavillage.exception.user.UserNotFoundException;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.model.Ticket;
import com.cinemavillage.model.user.Role;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import com.cinemavillage.repository.TicketRepository;
import com.cinemavillage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Business logic of the project (this particular service supports the API for the administrator)
 *
 * @author Michal Kawczak, Jakub Mikos
 */
@Service
@AllArgsConstructor
public class AdminService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public ResponseEntity<Screening> addScreening(Screening screening) {
        if (screening.getMovie() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        screeningRepository.save(screening);
        return ResponseEntity.ok(screening);
    }

    public ResponseEntity<?> deleteScreening(ObjectId id) {
        screeningRepository.delete(screeningRepository.findScreeningById(id));
        return ResponseEntity.ok("Deleted screening id: " + id);
    }

    public ResponseEntity<?> updateScreeningDate(ChangeScreeningTimeDTO changeScreeningTimeDTO) {
        LocalDateTime screeningTime = LocalDateTime.parse(changeScreeningTimeDTO.getCurrentScreeningDate());
        LocalDateTime newScreeningTime = LocalDateTime.parse(changeScreeningTimeDTO.getNewScreeningDate());
        Screening screening = screeningRepository.findScreeningByMovieTitleAndScreeningTime(
                changeScreeningTimeDTO.getMovieTitle(),
                screeningTime
        );
        screening.setScreeningTime(newScreeningTime);

        List<Ticket> tickets = ticketRepository.findTicketsByMovieNameAndMovieDate(
                        changeScreeningTimeDTO.getMovieTitle(),
                        screeningTime
                )
                .orElseThrow(TicketsNotFoundException::new);

        tickets.forEach(ticket -> ticket.setMovieDate(newScreeningTime));


        screeningRepository.save(screening);
        ticketRepository.saveAll(tickets);

        return ResponseEntity.ok("Screening: " +
                screening.getId() +
                " new date: " +
                screening.getScreeningTime());
    }

    public ResponseEntity<Movie> addMovie(Movie movie) {
        if (movieRepository.existsByTitle(movie.getTitle())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        movieRepository.save(movie);
        return ResponseEntity.ok(movie);
    }

    public ResponseEntity<?> deleteMovie(String title) {
        movieRepository.delete(movieRepository.findMovieByTitle(title));
        return ResponseEntity.ok("Deleted movie: " + title);
    }

    public ResponseEntity<?> updateMovie() {
        return null;
    }

    public ResponseEntity<?> deleteUser(String email) {
        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return ResponseEntity.ok("Deleted user: " + email);
    }

    public ResponseEntity<?> updateUsersRole(String userEmail, Role role) {
        User user = userRepository.findByEmailIgnoreCase(userEmail)
                .orElseThrow(UserNotFoundException::new);
        user.setRole(role);
        userRepository.save(user);
        return ResponseEntity.ok("User: " + userEmail + " has now role: " + role);
    }

    public ResponseEntity<?> deleteTicket() {
        return null;
    }
}
