package exercicio4;

public class Midia {
    private String nome;
    private String tipo;
    private String genero;
    private double precoLocacao;

    public Midia(String nome, String tipo, String genero, double precoLocacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.precoLocacao = precoLocacao;
    }

    // Getters e setters para os atributos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
}
