package com.cinemavillage.repository;

import com.cinemavillage.model.Ticket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {

    Optional<List<Ticket>> findTicketsByUserEmail(String userEmail);
    Optional<List<Ticket>> findTicketsByMovieNameAndMovieDate(String movieName, LocalDateTime movieDate);
}
