package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the alternativa database table.
 * 
 */
@Entity
@Table(name="alternativa")
public class Alternativa extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String texto;
	private boolean valor;

	//bi-directional many-to-one association to Questao
	@ManyToOne
	@JoinColumn(name="idquestao", referencedColumnName = "id", nullable = false)
	private Questao questao;

	//bi-directional many-to-one association to AlternativaAluno
	@OneToMany(mappedBy="alternativa")
	private List<AlternativaAluno> alternativaAlunos;

	public Alternativa() {
		this.texto = "";
		this.valor = false;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	public Questao getQuestao() {
		return this.questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public List<AlternativaAluno> getAlternativaAlunos() {
		return this.alternativaAlunos;
	}

	public void setAlternativaAlunos(List<AlternativaAluno> alternativaAlunos) {
		this.alternativaAlunos = alternativaAlunos;
	}
	
	@Override
	public boolean equals(Object obj){
		Alternativa alt = (Alternativa) obj;
		
		return alt.getTexto().equals(this.getTexto());
	}
	
	@Override
	public int hashCode() {
		return this.texto.hashCode();
	}

}