package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questao database table.
 * 
 */
@Entity
@Table(name="questao")
public class Questao extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String enunciado;
	private int pontuacao;
	
	//bi-directional many-to-one association to Conteudo
	@ManyToOne
	@JoinColumn(name="idconteudo")
	private Conteudo conteudo;

	//bi-directional many-to-one association to Alternativa
	@OneToMany(mappedBy="questao")
	private List<Alternativa> alternativas;

	public Questao() {
	}

	public String getEnunciado() {
		return this.enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Alternativa> getAlternativas() {
		return this.alternativas;
	}

	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}

	public Conteudo getConteudo() {
		return this.conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

}