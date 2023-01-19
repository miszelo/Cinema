package com.cinemavillage.controller.api;

import com.cinemavillage.controller.api.mapper.MovieMapper;
import com.cinemavillage.dto.ChangeScreeningTimeDTO;
import com.cinemavillage.dto.NewMovieDTO;
import com.cinemavillage.dto.NewScreeningDTO;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.model.user.Role;
import com.cinemavillage.repository.ScreeningRepository;
import com.cinemavillage.service.AdminService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Admin controller, these are the endpoints that enable the administrator to modify state of screenings, movies, user roles and tickets
 *
 * @author Mikos Jakub, Kawczak Michał
 * @see SpringApplication
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ScreeningRepository screeningRepository;
    private final MovieMapper movieMapper;

    @GetMapping("/get/screenings")
    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    @PostMapping("/add/screening")
    public ResponseEntity<Screening> addScreening(@RequestBody NewScreeningDTO newScreeningDTO) {
        return adminService.addScreening(newScreeningDTO);
    }

    @DeleteMapping("/delete/screening")
    public ResponseEntity<?> deleteScreening(@RequestParam ObjectId id) {
        return adminService.deleteScreening(id);
    }

    @PutMapping("/update/screening/date")
    public ResponseEntity<?> updateScreeningDate(@RequestBody ChangeScreeningTimeDTO changeScreeningTimeDTO) {
        return adminService.updateScreeningDate(changeScreeningTimeDTO);
    }

    @PostMapping("/add/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody NewMovieDTO newMovieDTO) {
        return adminService.addMovie(movieMapper.mapMovieDTOToMovie(newMovieDTO));
    }

    @DeleteMapping("/delete/movie")
    public ResponseEntity<?> deleteMovie(@RequestParam String title) {
        return adminService.deleteMovie(title);
    }

    @DeleteMapping("/delete/user")
    public ResponseEntity<?> deleteUser(@RequestParam String userEmail) {
        return adminService.deleteUser(userEmail);
    }

    @PutMapping("/update/user/role")
    public ResponseEntity<?> updateUsersRole(@RequestParam String userEmail, @RequestParam Role role) {
        return adminService.updateUsersRole(userEmail, role);
    }
}
