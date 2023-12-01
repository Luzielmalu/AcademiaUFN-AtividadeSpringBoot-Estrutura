package com.gerenciamento.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.biblioteca.model.Aluno;
@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long>{

	Optional<Aluno> findById(Aluno aluno);
	
}
