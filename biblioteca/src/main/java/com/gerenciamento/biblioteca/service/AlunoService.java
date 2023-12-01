package com.gerenciamento.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.biblioteca.model.Aluno;
import com.gerenciamento.biblioteca.repository.AlunoRepository;
@Service
public class AlunoService {

	@Autowired
	private final AlunoRepository alunoRepository;
	
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository= alunoRepository;
	}
	public void inicializarAluno() {
		
		alunoRepository.save(new Aluno(null, "Carlos", "1198574658"));
		alunoRepository.save(new Aluno(null, "Andreia", "11998745685"));
		alunoRepository.save(new Aluno(null, "Fabiana", "11954257896"));
	}
	public List<Aluno> getAllAlunos(){
		return (List<Aluno>) alunoRepository.findAll();
	}
	
	public Aluno getAlunoById(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}
	public Aluno createAluno(Aluno  novoAluno) {
		return alunoRepository.save(novoAluno);
	}
	public Aluno updateAluno(Long id, Aluno alunoAtualizado) {
        if (alunoRepository.existsById(id)) {
            alunoAtualizado.setId(id);
            return alunoRepository.save(alunoAtualizado);
        } else {
            return null; 
        }
    }

    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

}
