package com.cinemavillage.service;

import com.cinemavillage.dto.NewUserDTO;
import com.cinemavillage.exception.user.UserExistException;
import com.cinemavillage.model.user.Role;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<NewUserDTO> register(NewUserDTO newUserDTO) {
        if (userRepository.existsByEmail(newUserDTO.getUserEmail())) {
            throw new UserExistException();
        }

        User newUser = User.builder()
                .email(newUserDTO.getUserEmail())
                .password(bCryptPasswordEncoder.encode(newUserDTO.getUserPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(newUser);

        return ResponseEntity.ok(newUserDTO);
    }
}
