package com.example.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String primeiroNome;
	private String ultimoNome;

	private Cliente() {
		
	}

	public Cliente(Long id, String primeiroNome, String ultimoNome) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
	}

	@Override
	public String toString() {
		return String.format("Cliente [id=" + id + ", primeiroNome=" + primeiroNome + ", ultimoNome=" + ultimoNome + "]");
	}

	public Long getId() {
		return id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Cliente orElse(Object object) {
		return null;
	}
	
}
