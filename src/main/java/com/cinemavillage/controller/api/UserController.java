package com.cinemavillage.controller.api;


import com.cinemavillage.model.Ticket;
import com.cinemavillage.security.config.UserDetailsImpl;
import com.cinemavillage.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User controller, these are the endpoints that enable the user to get his tickets, change his password and cancel ticket reservation
 * @author Mikos Jakub, Kawczak Michał
 * @see SpringApplication
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/tickets")
    public ResponseEntity<List<Ticket>> getTickets(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.getTickets(userDetails);
    }

    @PutMapping("/update/password")
    public ResponseEntity<?> updatePassword() {
        return userService.updatePassword();
    }

    @DeleteMapping("/delete/ticket")
    public ResponseEntity<?> deleteTicket() {
        return userService.deleteTicket();
    }

}
