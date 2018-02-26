package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


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
	@OneToMany(cascade = CascadeType.MERGE, mappedBy="questao", fetch = FetchType.EAGER)
	private List<Alternativa> alternativas;

	public Questao() {
		this.alternativas = new ArrayList<Alternativa>();
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