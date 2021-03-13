package com.galvanize.RestSpring;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {

    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimals(@RequestBody Animal animal){
    }

    @GetMapping(path="/animals",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAnimals(){
        return "[{}]";
    }
}
