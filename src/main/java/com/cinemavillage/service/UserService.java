package com.cinemavillage.service;

import com.cinemavillage.exception.UserWithoutTicketsException;
import com.cinemavillage.exception.user.UserNotFoundException;
import com.cinemavillage.model.Ticket;
import com.cinemavillage.model.user.User;
import com.cinemavillage.repository.TicketRepository;
import com.cinemavillage.repository.UserRepository;
import com.cinemavillage.security.config.UserDetailsImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    public ResponseEntity<List<Ticket>> getTickets(UserDetailsImpl userDetails) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);
        List<Ticket> tickets = ticketRepository.findTicketsByUserEmail(user.getEmail())
                .orElseThrow(UserWithoutTicketsException::new);
        return ResponseEntity.ok(tickets);
    }

    public ResponseEntity<?> updatePassword() {
        return null;
    }

    public ResponseEntity<?> deleteTicket() {
        return null;
    }
}
