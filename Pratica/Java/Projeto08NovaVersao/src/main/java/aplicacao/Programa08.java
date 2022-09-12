package aplicacao;

import entidades.Questao;
import entidades.Resultado;
import modelo.ResultadoAtual;
import util.Cabecalhos;
import util.JPAUtil;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dao.QuestaoDao;
import dao.ResultadoDao;

public class Programa08 {
	public static void main(String[] args) {
        Cabecalhos.printTitle("JOGO COM PERGUNTAS!!");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("\nDigite seu nome para iniciar o jogo: ");
        String nome = scanner.nextLine();

        int erros = 0;
        int acertos = 0;
        int opcao;
        
        do {
        	System.out.println();
        	Cabecalhos.printSubTitle("MENU");
        	System.out.println("1 - Jogar Novamente" +
        						"\n2 - Ver Placar" +
        						"\n0 - Sair ");
        	
        	Scanner selecionado = new Scanner(System.in);
        	System.out.println("\nSelecione uma opcao: ");
            opcao = selecionado.nextInt();
        	
	        if(opcao == 1) {
	        	Questao retornandoQuestao = new Questao();
	    		
	    		EntityManager EntityM = JPAUtil.getEntityManager();
	    		QuestaoDao questaoDao = new QuestaoDao(EntityM);
	    		
	    		List<Questao> listaAcerto = questaoDao.buscarPergunta();
	    		
	    		Cabecalhos.printSubTitle("PERGUNTAS");
	    		for (Questao questao : listaAcerto) {
		    		if(questao.getAtiva() == true) {
		    			System.out.println("\nQUESTAO: " + questao.getPergunta());
		    			
		    			System.out.print("\nA questao e: " +
		    							"\n\nTRUE ou FALSE : ");
		                Boolean resposta = scanner.nextBoolean();
		    			
		    			if(resposta == questao.isVerdadeira()) {
		    				System.out.println("\n***RESPOSTA CERTA!!***");
		                    acertos++;
		    			}else {
		    				System.out.println("\n***RESPOSTA ERRADA!***");
		                    erros++;
		    			}
		    		}
	    		}
		        ResultadoAtual resultado = new ResultadoAtual(nome, acertos, erros);
		        System.out.println();
		        Cabecalhos.printSubTitle("RESULTADO");
		        System.out.println(resultado.toString());
		        Cabecalhos.separationLine();
		        
		        cadastroResultado(nome, acertos, erros);
                
	        }else if(opcao == 2) {
	        	Cabecalhos.printSubTitle("PLACAR");
	        	
	        	EntityManager EntityM = JPAUtil.getEntityManager();
	    		ResultadoDao resultadoDao = new ResultadoDao(EntityM);
	    		
	    		Resultado r = new Resultado();
	    		
	    		List<Resultado> todos = resultadoDao.busca();
	    		todos.forEach(res -> System.out.println("\nJOGADOR: " + r.getJogador() + 
	    				" ACERTOS: " + r.getAcertos() + " DATA: " + r.getDataDaPartida()));
	    		
	        }
        }while(opcao != 0);

        System.out.println("JOGO FINALIZADO!!");
        
    }
	
    private static void cadastroResultado(String nome, int acerto, int erro) {
    	
		Resultado addResultado = new Resultado(nome, acerto, erro);
		
		EntityManager EntityM = JPAUtil.getEntityManager();
		ResultadoDao resultadoDao = new ResultadoDao(EntityM);
		
		EntityM.getTransaction().begin();
		
		resultadoDao.cadastrar(addResultado);
		
		EntityM.getTransaction().commit();
		EntityM.close();
		
	}

}
