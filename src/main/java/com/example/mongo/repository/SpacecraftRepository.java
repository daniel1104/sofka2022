package com.example.mongo.repository;


import com.example.mongo.model.Spacecraft;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpacecraftRepository extends MongoRepository<Spacecraft, String> {
    Optional<Spacecraft> findById(String id);

}
