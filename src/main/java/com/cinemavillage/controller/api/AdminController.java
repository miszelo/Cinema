package com.cinemavillage.controller.api;

import com.cinemavillage.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/add/screening")
    public ResponseEntity<?> addScreening() {
        return adminService.addScreening();
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
    public ResponseEntity<?> addMovie() {
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
