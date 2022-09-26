package com.pb_molesoft_av03.estados_brasileiros.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;
import com.pb_molesoft_av03.estados_brasileiros.repository.UsuarioRepository;

public class PutUsuarioForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String email;
	
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

	public Usuario put(long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getReferenceById(id);
		
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		
		return usuario;
	}
}
