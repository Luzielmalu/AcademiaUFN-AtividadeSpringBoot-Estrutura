package com.ufn.animalSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufn.animalSpring.model.Animal;
import com.ufn.animalSpring.model.Cachorro;
import com.ufn.animalSpring.model.Gato;
import com.ufn.animalSpring.repository.AnimalRepository;


@Service
public class AnimalService {
	
    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void inicializarAnimais() {
        animalRepository.save(new Cachorro(null, "Cachorro", "Apolo", "Poodle", "Branca"));
        animalRepository.save(new Cachorro(null, "Cachorro", "Pipoca", "Viralata", "Caramelo"));
        animalRepository.save(new Cachorro(null, "Cachorro", "Duck", "Buldog", "Bege"));
        animalRepository.save(new Gato(null, "Gato", "Chiquita", "Srd", "Preta e branca"));
        animalRepository.save(new Gato(null, "Gato", "Tufinho", "Srd", "Preta"));
        animalRepository.save(new Gato(null, "Gato", "Lele", "Srd", "Cinza"));
        
        
    }

    public List<Animal> getAllAnimais() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal createAnimal(Animal novoAnimal) {
        return animalRepository.save(novoAnimal);
    }

    public Animal updateAnimal(Long id, Animal animalAtualizado) {
        if (animalRepository.existsById(id)) {
            animalAtualizado.setId(id);
            return animalRepository.save(animalAtualizado);
        } else {
            return null; 
        }
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

	

	
	
}




