package com.cinemavillage.service;

import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final ScreeningRepository screeningRepository;

    public ResponseEntity<?> addScreening(Screening screening) {
        screeningRepository.save(screening);
        return ResponseEntity.ok(screening);
    }

    public ResponseEntity<?> deleteScreening() {
        return null;
    }

    public ResponseEntity<?> updateScreening() {
        return null;
    }

    public ResponseEntity<?> addMovie() {
        return null;
    }

    public ResponseEntity<?> deleteMovie() {
        return null;
    }

    public ResponseEntity<?> updateMovie() {
        return null;
    }

    public ResponseEntity<?> deleteUser() {
        return null;
    }

    public ResponseEntity<?> updateUsersRole() {
        return null;
    }

    public ResponseEntity<?> deleteTicket() {
        return null;
    }
}
