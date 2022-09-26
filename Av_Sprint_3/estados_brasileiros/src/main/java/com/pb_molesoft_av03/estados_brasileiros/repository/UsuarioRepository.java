package com.pb_molesoft_av03.estados_brasileiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNome(String nomeUsuario);
}
