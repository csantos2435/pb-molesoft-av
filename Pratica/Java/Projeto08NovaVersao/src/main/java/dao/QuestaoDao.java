package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Questao;
import entidades.Resultado;

public class QuestaoDao {
	
private EntityManager EntityM;
	
	public QuestaoDao(EntityManager EntityM) {
		this.EntityM = EntityM;
	}
	
	public void cadastrar(Questao questao) {
		this.EntityM.persist(questao);
	}
	
	public List<Questao> buscarPergunta(){
		String jpql = "SELECT q FROM Questao q ";
		return EntityM.createQuery(jpql, Questao.class).getResultList();
	}
}
