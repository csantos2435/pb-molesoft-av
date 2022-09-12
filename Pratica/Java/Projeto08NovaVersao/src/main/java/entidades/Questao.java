package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questoes")
public class Questao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pergunta;
	private boolean resposta;
	private boolean ativa;
	
	public Questao() {
		
	}
	
	public Questao(String pergunta, boolean resposta, boolean ativa) {
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.ativa = ativa;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	
	public boolean isVerdadeira() {
		return resposta;
	}
	public void setVerdadeira(boolean resposta) {
		this.resposta = resposta;
	}
	
	public boolean getAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	} 
	
	
}
