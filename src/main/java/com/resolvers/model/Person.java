package com.resolvers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String name;
    private LocalDate birthDate;

}
