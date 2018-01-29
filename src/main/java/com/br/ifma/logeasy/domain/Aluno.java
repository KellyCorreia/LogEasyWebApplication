package com.br.ifma.logeasy.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@Table(name="aluno")
public class Aluno extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	 private String codigo;
	 private String nome;
	
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(name="idusuario")
	 private User usuario;
	 
	//bi-directional many-to-one association to Avatar
	@ManyToOne
	@JoinColumn(name="idavatar")
	private Avatar avatar;

	//bi-directional many-to-one association to AlternativaAluno
	@OneToMany(mappedBy="aluno")
	private List<AlternativaAluno> alternativasAluno;

	//bi-directional many-to-one association to GrupoConteudosAluno
	@OneToMany(mappedBy="aluno")
	private List<CursoAluno> cursosAluno;

	public Aluno() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<AlternativaAluno> getAlternativasAluno() {
		return alternativasAluno;
	}

	public void setAlternativasAluno(List<AlternativaAluno> alternativasAluno) {
		this.alternativasAluno = alternativasAluno;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<CursoAluno> getCursosAluno() {
		return cursosAluno;
	}

	public void setCursosAluno(List<CursoAluno> cursosAluno) {
		this.cursosAluno = cursosAluno;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
}