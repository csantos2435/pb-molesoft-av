package com.pb_molesoft_av03.estados_brasileiros.controller.dto;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;

public class DadosEspecificosUsuarioDto {

	private long id;
	private String nome;
	private String email;
	
	public DadosEspecificosUsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}
