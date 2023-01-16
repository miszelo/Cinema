package com.cinemavillage.repository;

import com.cinemavillage.model.Ticket;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, ObjectId> {

    List<Ticket> findTicketsByUserEmail(String userEmail);
}
