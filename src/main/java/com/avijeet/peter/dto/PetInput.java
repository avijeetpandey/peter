package com.avijeet.peter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PetInput {
    @NotBlank(message = "Pet name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Breed must be specified")
    private String breed;

    @Min(value = 0, message = "Age cannot be negative")
    private Integer age;
}
