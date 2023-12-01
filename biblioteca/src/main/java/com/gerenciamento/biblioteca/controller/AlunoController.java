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

import com.gerenciamento.biblioteca.model.Aluno;
import com.gerenciamento.biblioteca.service.AlunoService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(path="/alunos")
public class AlunoController {
	
	@Autowired
	private final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	@PostConstruct
	public void init() {
		alunoService.inicializarAluno();
	}
	@GetMapping
	public List<Aluno> getAllAlunos(){
		return alunoService.getAllAlunos();
	}
	@GetMapping("/{id}")
	public Aluno getAlunoById(@PathVariable Long id) {
		return alunoService.getAlunoById(id);
	}
	@PostMapping
	public Aluno createAluno(@RequestBody Aluno novoAluno) {
		return alunoService.createAluno(novoAluno);
	}
	@PutMapping("/{id}")
	public Aluno updateAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
		return alunoService.createAluno(alunoAtualizado);
		
	}
	public void deleteAluno(@PathVariable Long id) {
		alunoService.deleteAluno(id);
	}
	
	
}
