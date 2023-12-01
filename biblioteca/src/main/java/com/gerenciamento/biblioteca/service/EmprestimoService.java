package com.gerenciamento.biblioteca.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.biblioteca.model.Aluno;
import com.gerenciamento.biblioteca.model.Emprestimo;
import com.gerenciamento.biblioteca.model.Livro;
import com.gerenciamento.biblioteca.repository.AlunoRepository;
import com.gerenciamento.biblioteca.repository.EmprestimoRepository;
import com.gerenciamento.biblioteca.repository.LivroRepository;

import jakarta.el.ELException;
@Service
public class EmprestimoService {

	
	@Autowired
	private final EmprestimoRepository emprestimoRepository;
	@Autowired
    private final LivroRepository livroRepository;

    @Autowired
    private final AlunoRepository alunoRepository;
	
	public EmprestimoService(EmprestimoRepository emprestimoRepository) {
		this.emprestimoRepository= emprestimoRepository;
		this.livroRepository = null;
		this.alunoRepository = null;
	}
	
	public void inicializarEmprestimo() {
		
		Livro livro = livroRepository.findById(1L).orElse(null);
		Aluno aluno = alunoRepository.findById(1L).orElse(null);

		
		emprestimoRepository.save(new Emprestimo(null,livro , aluno, "14/11/2023", "17/11/2023", 3.0));
		emprestimoRepository.save(new Emprestimo(null,livro, aluno, "15/11/2023", "18/11/2023", 3.0));
		emprestimoRepository.save(new Emprestimo(null,livro, aluno, "16/11/2023", "19/11/2023", 3.0));
	}

		
	public List<Emprestimo> getAllEmprestimos(){
		return (List<Emprestimo>) emprestimoRepository.findAll();
	}
	
	public Emprestimo getEmprestimoById(Long id_emprestimo) {
		return emprestimoRepository.findById(id_emprestimo).orElse(null);
	}
	public Emprestimo createEmprestimo(Emprestimo  novoEmprestimo) {
		return emprestimoRepository.save(novoEmprestimo);
	}
	public Emprestimo updateEmprestimo(Long id_emprestimo, Emprestimo emprestimoAtualizado) {
        if (emprestimoRepository.existsById(id_emprestimo)) {
            emprestimoAtualizado.setId_emprestimo(id_emprestimo);
            return emprestimoRepository.save(emprestimoAtualizado);
        } else {
            return null;
        }
	}
	public void realizarDevolucao(Long id_emprestimo) throws ELException {

        Emprestimo emprestimo = emprestimoRepository.findById(id_emprestimo)
                .orElseThrow();

        emprestimo.setData_devolucao(null); 

        if (isDevolucaoAtrasada(emprestimo.getData_emprestimo(), emprestimo.getData_devolucao())) {
            long diasAtraso = calcularDiasAtraso(emprestimo.getData_emprestimo(), emprestimo.getData_devolucao());
            double multa = diasAtraso * 3.00;

            emprestimo.setMulta(multa);
        }

        emprestimoRepository.save(emprestimo);
    }
   
    private long calcularDiasAtraso(String data_emprestimo, String data_devolucao) {
		return 0;
	}
	private boolean isDevolucaoAtrasada(String data_emprestimo, String data_devolucao) {
		return false;
	}
	public void deleteEmprestimo(Long id_emprestimo) {
        emprestimoRepository.deleteById(id_emprestimo);
    }
	public void realizarEmprestimo(Long id_livro, Long id_aluno) {
		Livro livro = livroRepository.findById(id_livro).orElse(null);
        Aluno aluno = alunoRepository.findById(id_aluno).orElse(null);
        if (livro == null || aluno == null) {
            
            return;
        }
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setAluno(aluno);
        emprestimo.setData_emprestimo(new String()); 
        
        
        emprestimoRepository.save(emprestimo);


	}
	
	public void aplicarMulta(Long id_emprestimo) {
		Emprestimo emprestimo = emprestimoRepository.findById(id_emprestimo).orElse(null);
		
		if (emprestimo == null) {
            
            return;
        }

        if (emprestimo.getMulta() != null && emprestimo.getMulta() > 0) {
            
            return;
        }
        long diasAtraso = calcularDiasAtraso(emprestimo.getData_emprestimo(), new String());
        double multa = diasAtraso * 3.00; 

        emprestimo.setMulta(multa);
        emprestimoRepository.save(emprestimo);
	}
	

	public void realizarEmprestimo(Livro livro, Aluno aluno) {
		
	}
	
}
