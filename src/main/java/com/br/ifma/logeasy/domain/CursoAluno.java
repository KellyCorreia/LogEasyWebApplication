package com.br.ifma.logeasy.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the grupoconteudos_aluno database table.
 * 
 */
@Entity
@Table(name="curso_aluno")
public class CursoAluno extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private int pontuacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="idaluno")
	private Aluno aluno;

	//bi-directional many-to-one association to GrupoConteudo
	@ManyToOne
	@JoinColumn(name="idcurso")
	private Curso curso;

	public int getPontuacao() {
		return this.pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}