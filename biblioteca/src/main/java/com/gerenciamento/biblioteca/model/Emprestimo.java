package com.gerenciamento.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="emprestimos")
public class Emprestimo {
	
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id_emprestimo;
   
   @ManyToOne
   @JoinColumn(name = "id_livro")
   private Livro livro;

   @ManyToOne
   @JoinColumn(name = "id_aluno")
   private Aluno aluno;
   private String data_emprestimo;
   private String data_devolucao;
   private Double multa;
   
   
   public Emprestimo() {
	   
   }
   public Emprestimo(Long id_emprestimo, Livro livro, Aluno aluno, String data_emprestimo, String data_devolucao, Double multa) {
	super();
	this.id_emprestimo = id_emprestimo;
	this.livro = livro;
	this.aluno = aluno;
    this.data_emprestimo = data_emprestimo;
	this.data_devolucao = data_devolucao;
	this.multa = multa;
	
}

public Double getMulta() {
	return multa;
}

public void setMulta(Double multa) {
	this.multa = multa;
}

public Long getId_emprestimo() {
	return id_emprestimo;
}


public String getData_emprestimo() {
	return data_emprestimo;
}

public String getData_devolucao() {
	return data_devolucao;
}

public void setId_emprestimo(Long id_emprestimo) {
	this.id_emprestimo = id_emprestimo;
}


public Livro getLivro() {
	return livro;
}
public Aluno getAluno() {
	return aluno;
}
public void setLivro(Livro livro) {
	this.livro = livro;
}
public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}
public void setData_emprestimo(String data_emprestimo) {
	this.data_emprestimo = data_emprestimo;
}

public void setData_devolucao(String data_devolucao) {
	this.data_devolucao = data_devolucao;
}


   
}
