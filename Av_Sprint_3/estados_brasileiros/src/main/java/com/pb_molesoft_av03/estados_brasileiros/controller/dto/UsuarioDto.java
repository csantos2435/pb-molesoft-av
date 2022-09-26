package com.pb_molesoft_av03.estados_brasileiros.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;

public class UsuarioDto {
	
	private long id;
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
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
	public String getSenha() {
		return senha;
	}	
	
	public static List<UsuarioDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
}
