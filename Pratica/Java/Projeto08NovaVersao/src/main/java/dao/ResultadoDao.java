package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;

import entidades.Resultado;

public class ResultadoDao {
	
	private EntityManager EntityM;
	
	public ResultadoDao(EntityManager EntityM) {
		this.EntityM = EntityM;
	}
	
	public void cadastrar(Resultado resultado) {
		this.EntityM.persist(resultado);
	}
	
	public List<Resultado> busca() {
		String jpql = "SELECT r FROM Resultado r ORDER BY r.acertos DESC";
		return EntityM.createQuery(jpql, Resultado.class).getResultList();	
	}
}
