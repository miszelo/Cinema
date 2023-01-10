package com.cinemavillage.repository;

import com.cinemavillage.model.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmailIgnoreCase(String email);

    boolean existsByEmail(String userEmail);
}
