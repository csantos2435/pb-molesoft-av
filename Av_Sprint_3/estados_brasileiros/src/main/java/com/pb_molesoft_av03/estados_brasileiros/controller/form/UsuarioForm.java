package com.pb_molesoft_av03.estados_brasileiros.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;

public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String email;
	@NotNull @NotEmpty
	private String senha;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Usuario converter() {
		return new Usuario(nome, email, senha);
	}
}
