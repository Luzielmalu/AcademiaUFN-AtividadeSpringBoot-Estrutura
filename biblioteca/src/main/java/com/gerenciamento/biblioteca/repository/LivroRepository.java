package com.gerenciamento.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.biblioteca.model.Livro;
@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findById(Livro livro);
	List<Livro> findByTituloContainingIgnoreCase(String titulo);
    List<Livro> findByAutorContainingIgnoreCase(String autor);

}
