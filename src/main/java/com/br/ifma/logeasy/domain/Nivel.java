package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@Table(name="nivel")
public class Nivel extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	private int ordem;

	private int pontosQuestaoDefault;

	private int qtdPontosFinal;

	private int qtdPontosInicial;

	//bi-directional many-to-one association to Tema
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idambiente")
	private Ambiente ambiente;
	
	@OneToMany(mappedBy="nivel")
	private List<Conteudo> conteudos; 

	public Nivel() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPontosQuestaoDefault() {
		return this.pontosQuestaoDefault;
	}

	public void setPontosQuestaoDefault(int pontosQuestaoDefault) {
		this.pontosQuestaoDefault = pontosQuestaoDefault;
	}

	public int getQtdPontosFinal() {
		return this.qtdPontosFinal;
	}

	public void setQtdPontosFinal(int qtdPontosFinal) {
		this.qtdPontosFinal = qtdPontosFinal;
	}

	public int getQtdPontosInicial() {
		return this.qtdPontosInicial;
	}

	public void setQtdPontosInicial(int qtdPontosInicial) {
		this.qtdPontosInicial = qtdPontosInicial;
	}

	public Ambiente getTema() {
		return this.ambiente;
	}

	public void setTema(Ambiente tema) {
		this.ambiente = tema;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
}