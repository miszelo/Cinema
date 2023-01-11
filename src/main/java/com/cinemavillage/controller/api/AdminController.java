package com.cinemavillage.controller.api;

import com.cinemavillage.controller.api.mapper.MovieMapper;
import com.cinemavillage.controller.api.mapper.ScreeningMapper;
import com.cinemavillage.dto.NewMovieDTO;
import com.cinemavillage.dto.NewScreeningDTO;
import com.cinemavillage.model.Movie;
import com.cinemavillage.model.Screening;
import com.cinemavillage.service.AdminService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ScreeningMapper screeningMapper;

    private final MovieMapper movieMapper;

    @PostMapping("/add/screening")
    public ResponseEntity<Screening> addScreening(@RequestBody NewScreeningDTO newScreeningDTO) {
        return adminService.addScreening(screeningMapper.mapScreeningDTOToScreening(newScreeningDTO));
    }

    @DeleteMapping("/delete/screening")
    public ResponseEntity<?> deleteScreening(@RequestParam ObjectId id) {
        return adminService.deleteScreening(id);
    }

    @PutMapping("/update/screening")
    public ResponseEntity<?> updateScreening() {
        return adminService.updateScreening();
    }

    @PostMapping("/add/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody NewMovieDTO newMovieDTO) {
        return adminService.addMovie(movieMapper.mapMovieDTOToMovie(newMovieDTO));
    }

    @DeleteMapping("/delete/movie")
    public ResponseEntity<?> deleteMovie() {
        return adminService.deleteMovie();
    }

    @PutMapping("/update/movie")
    public ResponseEntity<?> updateMovie() {
        return adminService.updateMovie();
    }

    @DeleteMapping("/delete/user")
    public ResponseEntity<?> deleteUser() {
        return adminService.deleteUser();
    }

    @PutMapping("/update/user/role")
    public ResponseEntity<?> updateUsersRole() {
        return adminService.updateUsersRole();
    }

    @DeleteMapping("/delete/ticket")
    public ResponseEntity<?> deleteTicket() {
        return adminService.deleteTicket();
    }
}
