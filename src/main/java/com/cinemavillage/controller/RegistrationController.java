package com.cinemavillage.controller;

import com.cinemavillage.service.RegistrationService;
import com.cinemavillage.dto.NewUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    @PostMapping
    public ResponseEntity<NewUserDTO> register(@RequestBody NewUserDTO newUserDTO, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "/home");
        httpServletResponse.setStatus(302);
        return registrationService.register(newUserDTO);
    }

    @GetMapping
    public String register() {
        return "register";
    }
}
