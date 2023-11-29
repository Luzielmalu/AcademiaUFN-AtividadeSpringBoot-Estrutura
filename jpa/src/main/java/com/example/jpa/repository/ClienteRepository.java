package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	List<Cliente>findByUltimoNome(String ultimoNome);
	
	Cliente findById(long id);
}