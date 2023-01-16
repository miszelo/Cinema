package com.cinemavillage.controller.api;


import com.cinemavillage.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * User controler, these are the endpoints that enable the user to get his tickets, change his password and cancel ticket reservation
 * @author Mikos Jakub, Kawczak Michał
 * @see SpringApplication
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get/tickets")
    public ResponseEntity<?> getTickets() {
        return userService.getTickets();
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
