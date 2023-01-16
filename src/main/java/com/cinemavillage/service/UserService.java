package com.cinemavillage.service;

import com.cinemavillage.exception.userException.UserNotFoundException;
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
    public List<Ticket> getTickets(UserDetailsImpl userDetails) {
        User user = userRepository.findByEmailIgnoreCase(userDetails.getUsername())
                .orElseThrow(UserNotFoundException::new);

        return ticketRepository.findTicketsByUserEmail(user.getEmail());
    }

    public ResponseEntity<?> updatePassword() {
        return null;
    }

    public ResponseEntity<?> deleteTicket() {
        return null;
    }
}
