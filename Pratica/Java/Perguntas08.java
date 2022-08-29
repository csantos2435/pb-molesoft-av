import java.util.Scanner;

public class Perguntas08 {
	public static void main(String[] args) {
		String nome;
        int pergunta;
        int errou = 0;
        int acertou = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        nome = scanner.nextLine();

        System.out.println("Informe 1.true ou 2.false, em relacao a pergunta");
        System.out.println("");

        System.out.println("O tipo int e considerado um tipo de variavel inteiro? ");
        pergunta = scanner.nextInt();
        if (pergunta == 1) {
            System.out.println("Voce acertou!!");
            System.out.println("");
            acertou += 1;
        } else {
            System.out.println("Voce errou");
            System.out.println("");
            errou += 1;
        }
        System.out.println("Proxima pergunta!");

        System.out.println("A varivel String e usada para numero inteiro? ");
        pergunta = scanner.nextInt();
        if (pergunta == 2) {
            System.out.println("Voce acertou!!");
            System.out.println("");
            acertou += 1;
        } else {
            System.out.println("Voce errou");
            System.out.println("");
            errou += 1;
        }
        System.out.println("Proxima pergunta!");

        System.out.println("O Java e uma Linguagem de Programacao? ");
        pergunta = scanner.nextInt();
        if (pergunta == 1) {
            System.out.println("Voce acertou!!");
            System.out.println("");
            acertou += 1;
        } else {
            System.out.println("Voce errou");
            System.out.println("");
            errou += 1;
        }

        System.out.println("Jogador: " + nome);
        System.out.println("Acertou: " + acertou);
        System.out.println("Errou: " + errou);

	}
}
