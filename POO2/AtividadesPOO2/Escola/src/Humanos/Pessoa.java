package Humanos;

public class Pessoa {
    protected String nome, tipo_olhos, cor;
    protected float altura;
    protected int idade;

    public Pessoa(String nome, String tipo_olhos, String cor, float altura, int idade) {
        this.nome = nome;
        this.tipo_olhos = tipo_olhos;
        this.cor = cor;
        this.altura = altura;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo_olhos() {
        return tipo_olhos;
    }

    public String getCor() {
        return cor;
    }

    public float getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }
}