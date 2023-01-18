package com.cinemavillage.service;

import com.cinemavillage.dto.ChangePasswordDTO;
import com.cinemavillage.dto.DeleteTicketDTO;
import com.cinemavillage.exception.PasswordIsTheSameException;
import com.cinemavillage.exception.TicketNotFoundException;
import com.cinemavillage.exception.UserWithoutTicketsException;
import com.cinemavillage.exception.user.UserNotFoundException;
import com.cinemavillage.model.Ticket;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.TicketRepository;
import com.cinemavillage.repository.UserRepository;
import com.cinemavillage.security.config.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public ResponseEntity<List<Ticket>> getTickets(UserDetailsImpl userDetails) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);
        List<Ticket> tickets = ticketRepository.findTicketsByUserEmail(user.getEmail())
                .orElseThrow(UserWithoutTicketsException::new);
        return ResponseEntity.ok(tickets);
    }

    public ResponseEntity<?> updatePassword(UserDetailsImpl userDetails, ChangePasswordDTO changePasswordDTO) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);
        if (bCryptPasswordEncoder.matches(changePasswordDTO.getNewPassword(), user.getPassword())) {
            throw new PasswordIsTheSameException();
        }
        user.setPassword(bCryptPasswordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Password changed!");
    }

    public ResponseEntity<?> deleteTicket(DeleteTicketDTO deleteTicketDTO) {
        Ticket ticket = ticketRepository.findTicketByTicketCode(deleteTicketDTO.getTicketCode())
                .orElseThrow(TicketNotFoundException::new);
        ticketRepository.delete(ticket);
        return ResponseEntity.ok("Ticket :" + ticket.getTicketCode() + " deleted!");
    }
}
