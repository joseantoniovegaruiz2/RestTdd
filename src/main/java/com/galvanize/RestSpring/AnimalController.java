package com.galvanize.RestSpring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {
    private AnimalDto animalDto=new AnimalDto();

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody Animal animal){
        this.animalDto.addAnimal(animal);
    }

    @GetMapping(path="/animals",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAnimals() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this.animalDto.getAnimalList());
    }

    @PutMapping(path="/animals/treat/{name}")
    public void giveTreat(@PathVariable String name){

    }

}
