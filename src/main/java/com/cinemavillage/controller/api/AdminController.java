package com.cinemavillage.controller.api;

import com.cinemavillage.controller.api.mapper.ScreeningMapper;
import com.cinemavillage.dto.NewMovieDTO;
import com.cinemavillage.dto.NewScreeningDTO;
import com.cinemavillage.model.Screening;
import com.cinemavillage.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final ScreeningMapper screeningMapper;

    @PostMapping("/add/screening")
    public ResponseEntity<Screening> addScreening(@RequestBody NewScreeningDTO newScreeningDTO) {
        return adminService.addScreening(screeningMapper.mapScreeningDTOToScreening(newScreeningDTO));
    }

    @DeleteMapping("/delete/screening")
    public ResponseEntity<?> deleteScreening() {
        return adminService.deleteScreening();
    }

    @PutMapping("/update/screening")
    public ResponseEntity<?> updateScreening() {
        return adminService.updateScreening();
    }

    @PostMapping("/add/movie")
    public ResponseEntity<?> addMovie(@RequestBody NewMovieDTO newMovieDTO) {
        return adminService.addMovie();
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
