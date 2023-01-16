package com.cinemavillage.service;

import com.cinemavillage.exception.user.UserNotFoundException;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.model.user.Role;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.MovieRepository;
import com.cinemavillage.repository.ScreeningRepository;
import com.cinemavillage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Business logic of the project (this particular service supports the API for the administrator)
 * @author Michal Kawczak, Jakub Mikos
 */
@Service
@AllArgsConstructor
public class AdminService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private UserRepository userRepository;

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

    public ResponseEntity<?> updateScreening() {
        return null;
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
