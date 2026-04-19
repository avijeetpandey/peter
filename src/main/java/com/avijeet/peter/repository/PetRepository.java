package com.avijeet.peter.repository;

import com.avijeet.peter.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
}
