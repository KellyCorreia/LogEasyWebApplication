package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@Table(name="professor")
public class Professor extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="idusuario")
	private User usuario;
	
	//bi-directional many-to-one association to Conteudo
	@OneToMany(mappedBy="professor")
	@Basic(fetch = FetchType.LAZY)
	private List<Conteudo> conteudos;

	public Professor() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		Professor prof = (Professor) obj;
		return this.id.equals(prof.id);
	}
}