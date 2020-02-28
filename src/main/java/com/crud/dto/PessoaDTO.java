package com.crud.dto;

public class PessoaDTO extends DTOImpl {

	private static final long serialVersionUID = 1L;

	private Long idPessoa;

	private String nome;

	private String email;

	public PessoaDTO() {
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
