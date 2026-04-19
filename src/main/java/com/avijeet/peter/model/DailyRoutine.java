package com.avijeet.peter.model;

import com.avijeet.peter.enums.TaskType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "daily_routines")
public class DailyRoutine {
    @Id
    private String id;
    private String petId;
    private TaskType taskType;
    private String scheduledTime;
    private Boolean completed;
}
