package com.galvanize.RestSpring;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnimalDto {
    private List<Animal> animalList=new ArrayList<>();

    public AnimalDto() {
    }

    public AnimalDto(Animal animal) {
        this.animalList.add(animal);
    }

    public void addAnimal(Animal animal){
        this.animalList.add(animal);
    }

    public void giveTreat(String name){}

}
