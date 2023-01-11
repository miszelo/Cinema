package com.cinemavillage.service;

import com.cinemavillage.model.Screening;
import com.cinemavillage.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final ScreeningRepository screeningRepository;

    public ResponseEntity<Screening> addScreening(Screening screening) {
        if (screening.getMovie() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        screeningRepository.save(screening);
        return ResponseEntity.ok(screening);
    }

    public ResponseEntity<?> deleteScreening(ObjectId id) {
        screeningRepository.delete(screeningRepository.findScreeningById(id));
        return ResponseEntity.ok("Deleted");
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
