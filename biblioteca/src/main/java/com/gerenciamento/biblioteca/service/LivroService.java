package com.gerenciamento.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.biblioteca.model.Livro;
import com.gerenciamento.biblioteca.repository.LivroRepository;
@Service
public class LivroService {
	
	
	@Autowired
	private final LivroRepository livroRepository;
	
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository= livroRepository;
	}
	
	
	public List<Livro> buscarLivrosPorAutor(String autor) {
        return livroRepository.findByAutorContainingIgnoreCase(autor);
    }
	
    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }
	public void inicializarLivro() {
		
		livroRepository.save(new Livro(null, "O poder do Hábito", "Charles Duhigg", 2015));
		livroRepository.save(new Livro(null, "Metas", "Brian Tracy", 2013));
		livroRepository.save(new Livro(null, "Grey", "E.L James", 2016));
	}
	public List<Livro> getAllLivros(){
		return (List<Livro>) livroRepository.findAll();
	}
	
	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	public Livro createLivro(Livro  novoLivro) {
		return livroRepository.save(novoLivro);
	}
	public Livro updateLivro(Long id, Livro livroAtualizado) {
        if (livroRepository.existsById(id)) {
            livroAtualizado.setId(id);
            return livroRepository.save(livroAtualizado);
        } else {
            return null; 
        }
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

}
