package com.ufn.animalSpring.model;

public class Gato extends Animal{

	

	public Gato(Long id, String especie, String nome, String raca, String pelagem) {
		super(id, especie, nome, raca, pelagem);
		
	}

	@Override
	public void emitirSom() {
		System.out.println("Miando");
	}
}
