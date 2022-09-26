package com.pb_molesoft_av03.estados_brasileiros.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Estado;
import com.pb_molesoft_av03.estados_brasileiros.modelo.Regiao;

public class EstadoDto {
	
	private long id;
	private String nome;
	private Regiao regiao;
	private long populacao;
	private String capital;
	private BigDecimal area;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.capital = estado.getCapital();
		this.area = estado.getArea();
	}

	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public long getPopulacao() {
		return populacao;
	}
	public String getCapital() {
		return capital;
	}
	public BigDecimal getArea() {
		return area;
	}

	public static List<EstadoDto> converter(List<Estado> estado) {
		return estado.stream().map(EstadoDto::new).collect(Collectors.toList());
	}
}
