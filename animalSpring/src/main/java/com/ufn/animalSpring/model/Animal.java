package com.ufn.animalSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "animais")
public abstract class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="especie", nullable = false)
	private String especie;
	@Column(name="nome")
	private String nome;
	@Column(name="raca")
	private String raca;
	@Column(name="pelagem")
	private String pelagem;
	
	
	public Animal(Long id, String especie,String nome, String raca, String pelagem) {
		this.id = id;
		this.especie = especie;
		this.nome = nome;
		this.raca = raca;
		this.pelagem = pelagem;
		
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNome() {
		return nome;
	}

	public String getRaca() {
		return raca;
	}

	public String getPelagem() {
		return pelagem;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public void setPelagem(String pelagem) {
		this.pelagem = pelagem;
	}
	
	public  abstract void emitirSom();
}
