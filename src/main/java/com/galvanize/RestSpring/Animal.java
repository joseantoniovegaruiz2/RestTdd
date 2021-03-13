package com.galvanize.RestSpring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal {
    private String name;
    private AnimalType animalType;
    private Mood mood=Mood.UNHAPPY;
}
