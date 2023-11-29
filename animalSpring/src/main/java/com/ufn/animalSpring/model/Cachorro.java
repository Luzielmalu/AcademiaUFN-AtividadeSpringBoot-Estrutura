package com.ufn.animalSpring.model;

public class Cachorro extends Animal {

	

	public Cachorro(Long id,String especie, String nome, String raca, String pelagem) {
		super(id, especie, nome, raca, pelagem);
		
		
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Latindo");		
	}

	
	

	
}
