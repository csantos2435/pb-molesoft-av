package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Questao;

public class QuestaoDao {
	
private EntityManager EntityM;
	
	public QuestaoDao(EntityManager EntityM) {
		this.EntityM = EntityM;
	}
	
	public List<Questao> buscarPergunta(){
		String jpql = "SELECT q FROM Questao q ";
		return EntityM.createQuery(jpql, Questao.class).getResultList();
	}
}
