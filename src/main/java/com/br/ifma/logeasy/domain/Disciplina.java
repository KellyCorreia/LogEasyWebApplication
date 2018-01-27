package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@Table(name="disciplina")
public class Disciplina extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	 private String codigo;
	 private String nome;
	 private String descricao;

	//bi-directional many-to-one association to Grupoconteudo
	@OneToMany(mappedBy="disciplina")
	private List<Curso> cursos;

	public Disciplina() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}