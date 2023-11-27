package com.ufn.animalSpring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;

import com.ufn.animalSpring.model.Animal;

@Repository
public class AnimalRepositoryEmMemoria implements AnimalRepository {

    private final List<Animal> animais = new ArrayList<>();
    private Long proximoId = 1L;

    @Override
    public List<Animal> findAll() {
        return animais;
    }

    @Override
    public Optional<Animal> findById(Long id) {
        return animais.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public Animal save(Animal animal) {
        animal.setId(proximoId++);
        animais.add(animal);
        return animal;
    }

    @Override
    public void deleteById(Long id) {
        animais.removeIf(a -> a.getId().equals(id));
    }

	@Override
	public boolean existsById(Long id) {
		
		return false;
	}

}