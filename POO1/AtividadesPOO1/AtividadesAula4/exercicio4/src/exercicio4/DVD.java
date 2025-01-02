package exercicio4;

public class DVD extends Midia {
    private String diretor;
    private int duracao;
    private String[] atores;

    public DVD(String nome, String genero, double precoLocacao, String diretor, int duracao, String[] atores) {
        super(nome, "Vídeo", genero, precoLocacao);
        this.diretor = diretor;
        this.duracao = duracao;
        this.atores = atores;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String[] getAtores() {
        return atores;
    }

    public void setAtores(String[] atores) {
        this.atores = atores;
    }
}