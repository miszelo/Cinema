package com.cinemavillage.controller;

import com.cinemavillage.dto.NewUserDTO;
import com.cinemavillage.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<NewUserDTO> register(@RequestBody NewUserDTO newUserDTO) {
        return registrationService.register(newUserDTO);
    }

    @GetMapping
    public String register() {
        return "register";
    }
}
