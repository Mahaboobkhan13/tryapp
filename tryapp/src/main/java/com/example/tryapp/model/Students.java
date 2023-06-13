package com.example.tryapp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "St'marys")
public class Students
{
    @Id
    @NotBlank
    private String name;
    private String sec;
    private int phone_number;
    private String DOB;

}
