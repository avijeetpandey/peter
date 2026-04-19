package com.avijeet.peter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "pets")
public class Pet {
    @Id
    private String id;
    private String name;
    private String breed;
    private Integer age;
}
