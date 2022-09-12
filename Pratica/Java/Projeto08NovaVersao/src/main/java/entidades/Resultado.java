package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resultados")
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String jogador;
	private Integer acertos;
	private Integer erros;
	private LocalDate dataDaPartida = LocalDate.now();
	
	public Resultado() {
		
	}
	
	public Resultado(String jogador, Integer acertos, Integer erros) {
		this.jogador = jogador;
		this.acertos = acertos;
		this.erros = erros;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	
	public Integer getAcertos() {
		return acertos;
	}
	public void setAcertos(Integer acertos) {
		this.acertos = acertos;
	}
	
	public Integer getErros() {
		return erros;
	}
	public void setErros(Integer erros) {
		this.erros = erros;
	}
	
	public LocalDate getDataDaPartida() {
		return dataDaPartida;
	}
	public void setDataDaPartida(LocalDate dataDaPartida) {
		this.dataDaPartida = dataDaPartida;
	}

	
}
