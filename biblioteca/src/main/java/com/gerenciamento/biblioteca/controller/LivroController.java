package com.gerenciamento.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.biblioteca.model.Livro;
import com.gerenciamento.biblioteca.service.LivroService;

import jakarta.annotation.PostConstruct;
@RestController
@RequestMapping(name="/livros")
public class LivroController {

		
	@Autowired
	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	@PostConstruct
	public void init() {
		livroService.inicializarLivro();
	}
	@GetMapping
	public List<Livro> getAllLivros(){
		return livroService.getAllLivros();
	}
	@GetMapping("/{id}")
	public Livro getLivroById(@PathVariable Long id) {
		return livroService.getLivroById(id);
	}
	@PostMapping
	public Livro createLivro(@RequestBody Livro novoLivro) {
		return livroService.createLivro(novoLivro);
	}
	@PutMapping("/{id}")
	public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
		return livroService.createLivro(livroAtualizado);
		
	}
	public void deleteLivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}
	
}
