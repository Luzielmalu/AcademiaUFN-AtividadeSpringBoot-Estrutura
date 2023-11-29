package com.ufn.animalSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ufn.animalSpring.model.Animal;

@Repository
public interface AnimalRepository {
    List<Animal> findAll();
    Optional<Animal> findById(Long id);
    Animal save(Animal animal);
    void deleteById(Long id);
	boolean existsById(Long id);
	
 }
