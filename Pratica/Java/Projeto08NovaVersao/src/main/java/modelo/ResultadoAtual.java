package modelo;

public class ResultadoAtual{

    private String nome;

    private int acertos;

    private int erros;

    public ResultadoAtual(String nome, int acertos, int erros) {
        this.nome = nome;
        this.acertos = acertos;
        this.erros = erros;
    }

    @Override
    public String toString() {
        return "Jogador " + nome +
                "\nAcertos: " + acertos +
                "\nErros: " + erros;
    }
}
