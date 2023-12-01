package com.gerenciamento.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gerenciamento.biblioteca.model.Aluno;
import com.gerenciamento.biblioteca.model.Emprestimo;
import com.gerenciamento.biblioteca.model.Livro;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long>{
	Optional<Emprestimo> findById(Long id_emprestimo);

	void saveAndFlush(Emprestimo emprestimo);


	
}
