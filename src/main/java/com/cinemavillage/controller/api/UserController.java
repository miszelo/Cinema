package com.cinemavillage.controller.api;


import com.cinemavillage.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
