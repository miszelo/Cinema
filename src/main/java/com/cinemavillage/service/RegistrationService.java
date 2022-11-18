package com.cinemavillage.service;

import com.cinemavillage.dto.NewUserDTO;
import com.cinemavillage.exception.UserExistException;
import com.cinemavillage.model.Role;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<NewUserDTO> register(NewUserDTO newUserDTO) {
        if (userRepository.existsByUserEmail(newUserDTO.getUserEmail())) {
            throw new UserExistException();
        }

        User newUser = User.builder()
                .userEmail(newUserDTO.getUserEmail())
                .userPassword(bCryptPasswordEncoder.encode(newUserDTO.getUserPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(newUser);

        return ResponseEntity.ok(newUserDTO);
    }
}
