package com.avijeet.peter.dto;

import com.avijeet.peter.enums.TaskType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoutineInput {
    @NotBlank(message = "Pet ID is required")
    private String petId;

    @NotNull(message = "Task type is required")
    private TaskType taskType;

    @NotBlank(message = "Scheduled time cannot be empty")
    private String scheduledTime;
}
