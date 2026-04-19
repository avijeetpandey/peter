package com.avijeet.peter.controller;

import com.avijeet.peter.dto.PetInput;
import com.avijeet.peter.model.DailyRoutine;
import com.avijeet.peter.model.Pet;
import com.avijeet.peter.repository.DailyRoutineRepository;
import com.avijeet.peter.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PetGraphQLController {
    private final PetService petService;
    private final DailyRoutineRepository dailyRoutineRepository;

    @QueryMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @QueryMapping
    public Pet getPetById(String id) {
        return petService.getPetById(id);
    }

    @MutationMapping
    public Pet createPet(@Valid @Argument PetInput input) {
        return petService.createPet(input);
    }

    @SchemaMapping(typeName = "Pet", field = "routines")
    public List<DailyRoutine> getRoutines(Pet pet) {
        return dailyRoutineRepository.findByPetId(pet.getId());
    }
}
