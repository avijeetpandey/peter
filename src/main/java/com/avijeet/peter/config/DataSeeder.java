package com.avijeet.peter.config;

import com.avijeet.peter.enums.TaskType;
import com.avijeet.peter.model.DailyRoutine;
import com.avijeet.peter.model.Pet;
import com.avijeet.peter.repository.DailyRoutineRepository;
import com.avijeet.peter.repository.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(PetRepository petRepository, DailyRoutineRepository routineRepository) {
        return args -> {
            petRepository.deleteAll();
            routineRepository.deleteAll();

            if (petRepository.count() == 0) {
                Pet pet = new Pet();
                pet.setName("Aiko");
                pet.setBreed("Golden Retriever");
                pet.setAge(5);
                pet.setOwnerName("Avijeet");
                pet = petRepository.save(pet);

                DailyRoutine walk = new DailyRoutine();
                walk.setPetId(pet.getId());
                walk.setTaskType(TaskType.WALK);
                walk.setScheduledTime("07:00 AM");
                walk.setCompleted(false);
                routineRepository.save(walk);

                DailyRoutine feeding = new DailyRoutine();
                feeding.setPetId(pet.getId());
                feeding.setTaskType(TaskType.FEEDING);
                feeding.setScheduledTime("08:00 AM");
                feeding.setCompleted(false);
                routineRepository.save(feeding);

                System.out.println("✅ Database wiped and re-seeded successfully!");
            }
        };
    }
}