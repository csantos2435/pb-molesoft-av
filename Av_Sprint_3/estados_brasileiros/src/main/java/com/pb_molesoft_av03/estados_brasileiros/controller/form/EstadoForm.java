package com.pb_molesoft_av03.estados_brasileiros.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.pb_molesoft_av03.estados_brasileiros.modelo.Estado;
import com.pb_molesoft_av03.estados_brasileiros.modelo.Regiao;
import com.pb_molesoft_av03.estados_brasileiros.repository.EstadoRepository;

public class EstadoForm {
	
	@NotNull @NotEmpty
	private String nome;
	private Regiao regiao;
	@NotNull 
	private long populacao;
	@NotNull @NotEmpty
	private String capital;
	@NotNull 
	private BigDecimal area;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Estado converter() {
		return new Estado(nome, regiao, populacao, capital, area);
	}

	public Estado put(long id, EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.getReferenceById(id);
		
		estado.setNome(this.nome);
		estado.setRegiao(this.regiao);
		estado.setPopulacao(this.populacao);
		estado.setCapital(this.capital);
		estado.setArea(this.area);
		
		return estado;
	}
	
	
}
