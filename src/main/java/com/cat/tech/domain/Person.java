package com.cat.tech.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document("domo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @MongoId
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
}
