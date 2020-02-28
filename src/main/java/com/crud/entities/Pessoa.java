package com.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.crud.entity.EntityImpl;

@Entity
public class Pessoa extends EntityImpl {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "GENERATOR_IDPESSOA_SEQ", sequenceName = "IDPESSOA_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERATOR_IDPESSOA_SEQ")
	private Long idPessoa;

	private String nome;

	private String email;

	public Pessoa() {
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Long getId() {
		return idPessoa;
	}

}
