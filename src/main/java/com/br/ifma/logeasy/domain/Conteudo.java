package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the conteudo database table.
 * 
 */
@Entity
@Table(name="conteudo")
public class Conteudo extends AbstractDomainClass implements Serializable{
	private static final long serialVersionUID = 1L;

	private String licao;

	private String dica;
	
	private String nome;
	
	//bi-directional many-to-one association to Professor
	@ManyToOne
	@JoinColumn(name="idprofessor")
	@Basic(fetch = FetchType.LAZY)
	private Professor professor;
	
	//bi-directional many-to-one association to GrupoConteudo
	@ManyToOne
	@JoinColumn(name="idcurso")
	@Basic(fetch = FetchType.LAZY)
	private Curso curso;
		
	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="idnivel")
	@Basic(fetch = FetchType.LAZY)
	private Nivel nivel;

	//bi-directional many-to-one association to Questao
	@OneToMany(mappedBy="conteudo")
	@Basic(fetch = FetchType.LAZY)
	private List<Questao> questoes;

	public Conteudo() {
	}

	public String getLicao() {
		return licao;
	}

	public void setLicao(String licao) {
		this.licao = licao;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getGrupoConteudo() {
		return curso;
	}

	public void setGrupoConteudo(Curso grupoConteudo) {
		this.curso = grupoConteudo;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.dica + " - " + this.licao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
