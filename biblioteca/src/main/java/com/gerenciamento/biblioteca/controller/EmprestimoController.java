package com.gerenciamento.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.biblioteca.model.Aluno;
import com.gerenciamento.biblioteca.model.Emprestimo;
import com.gerenciamento.biblioteca.model.Livro;
import com.gerenciamento.biblioteca.service.EmprestimoService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping(path="/emprestimos")
public class EmprestimoController {

	
	@Autowired
    private EmprestimoService emprestimoService;
	
	public EmprestimoController(EmprestimoService emprestimoService) {
		this.emprestimoService = emprestimoService;
	}
	@PostConstruct
	public void init() {
		emprestimoService.inicializarEmprestimo();
	}
	@GetMapping
	public List<Emprestimo> getAllEmprestimos(){
		return emprestimoService.getAllEmprestimos();
	}
	@GetMapping("/{id_emprestimo}")
	public Emprestimo getEmprestimoById(@PathVariable Long id_emprestimo) {
		return emprestimoService.getEmprestimoById(id_emprestimo);
	}

    @PostMapping("/realizar-emprestimo/{id_livro}/{id_aluno}")
    public ResponseEntity<String> realizarEmprestimo(
            @PathVariable Livro id_livro,
            @PathVariable Aluno id_aluno) {
        emprestimoService.realizarEmprestimo(id_livro, id_aluno);
		return ResponseEntity.ok("Empréstimo realizado com sucesso.");
    }

    @PostMapping("/realizar-devolucao/{id_emprestimo}")
    public ResponseEntity<String> realizarDevolucao(@PathVariable Long id_emprestimo) {
        emprestimoService.realizarDevolucao(id_emprestimo);
		return ResponseEntity.ok("Devolução realizada com sucesso.");
    }

    @PostMapping("/aplicar-multa/{id_emprestimo}")
    public ResponseEntity<String> aplicarMulta(@PathVariable Long id_emprestimo) {
        emprestimoService.aplicarMulta(id_emprestimo);
		return ResponseEntity.ok("Multa aplicada com sucesso.");
    }
    public void deleteEmprestimo(@PathVariable Long id_emprestimo) {
		emprestimoService.deleteEmprestimo(id_emprestimo);
	}
}

