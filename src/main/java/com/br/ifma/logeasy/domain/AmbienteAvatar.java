package com.br.ifma.logeasy.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the tema_avatar database table.
 * 
 */
@Entity
@Table(name="ambiente_avatar")
public class AmbienteAvatar extends AbstractDomainClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String falaInicialNivel;

	//bi-directional many-to-one association to Avatar
	@ManyToOne
	@JoinColumn(name="idavatar")
	private Avatar avatar;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idambiente")
	private Ambiente ambiente;

	public AmbienteAvatar() {
	}

	public String getFalaInicialNivel() {
		return this.falaInicialNivel;
	}

	public void setFalaInicialNivel(String falaInicialNivel) {
		this.falaInicialNivel = falaInicialNivel;
	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

}