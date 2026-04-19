package com.avijeet.peter.repository;

import com.avijeet.peter.model.DailyRoutine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DailyRoutineRepository extends MongoRepository<DailyRoutine, String> {
    List<DailyRoutine> findByPetId(String petId);
}
