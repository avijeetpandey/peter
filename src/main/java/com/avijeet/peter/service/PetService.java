package com.avijeet.peter.service;

import com.avijeet.peter.dto.PetInput;
import com.avijeet.peter.dto.RoutineInput;
import com.avijeet.peter.exception.ResourceNotFoundException;
import com.avijeet.peter.model.DailyRoutine;
import com.avijeet.peter.model.Pet;
import com.avijeet.peter.repository.DailyRoutineRepository;
import com.avijeet.peter.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final DailyRoutineRepository dailyRoutineRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(String id) {
        return petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found with id: " + id));
    }

    public Pet createPet(PetInput petInput) {
        Pet pet = new Pet();
        pet.setName(petInput.getName());
        pet.setBreed(petInput.getBreed());
        pet.setAge(petInput.getAge());
        pet.setOwnerName(petInput.getOwnerName());
        return petRepository.save(pet);
    }

    public DailyRoutine addRoutine(RoutineInput input) {
        getPetById(input.getPetId());

        DailyRoutine routine = new DailyRoutine();
        routine.setPetId(input.getPetId());
        routine.setTaskType(input.getTaskType());
        routine.setScheduledTime(input.getScheduledTime());
        routine.setCompleted(false);

        return dailyRoutineRepository.save(routine);
    }
}
