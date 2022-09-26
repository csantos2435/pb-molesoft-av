package com.pb_molesoft_av03.estados_brasileiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	List<Estado> findByRegiao(String nomeRegiao);
}
