package com.pb_molesoft_av03.estados_brasileiros.modelo;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estado {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Regiao regiao;
	private long populacao;
	private String capital;
	private BigDecimal area;
	
	public Estado() {
		
	}	
	
	public Estado(String nome, Regiao regiao, long populacao, String capital, BigDecimal area) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, regiao, populacao, capital, area);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(area, other.area) && Objects.equals(capital, other.capital) && id == other.id
				&& Objects.equals(nome, other.nome) && populacao == other.populacao && regiao == other.regiao;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	
	
}
