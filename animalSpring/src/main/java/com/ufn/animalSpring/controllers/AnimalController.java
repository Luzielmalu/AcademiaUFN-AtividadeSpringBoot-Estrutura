package com.ufn.animalSpring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufn.animalSpring.model.Animal;
import com.ufn.animalSpring.service.AnimalService;

import jakarta.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

	
    private final AnimalService animalService;
    
    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostConstruct
    public void init() {
        animalService.inicializarAnimais();
    }

    @GetMapping
    public List<Animal> getAllAnimais() {
        return animalService.getAllAnimais();
    }

    @GetMapping("/animais/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal novoAnimal) {
        return animalService.createAnimal(novoAnimal);
    }

    @PutMapping("/animais/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animalAtualizado) {
        return animalService.updateAnimal(id, animalAtualizado);
    }

    @DeleteMapping("/animais/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }
}


