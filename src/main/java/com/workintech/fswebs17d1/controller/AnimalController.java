package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    @GetMapping("/animal")
    public List<Animal> getAllAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/animal/{id}")
    public Animal getAnimal(@PathVariable long id) {
        return animals.get((int) id);
    }

    @PostMapping("/animal")
    public Animal saveAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        return animals.remove(id);
    }
}
