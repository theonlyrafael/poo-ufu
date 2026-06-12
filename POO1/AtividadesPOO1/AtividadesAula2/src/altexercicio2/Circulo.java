package altexercicio2;

import exercicio2.Ponto;

public class Circulo {
private String nome;
private Ponto centro;
private int raio;

public void iniciarCirculo(String nome, Ponto centro, int raio) {
    this.nome = nome;
    this.centro = centro;
    this.raio = raio;
}

public void setNome(String nome) {
    if (!nome.isEmpty()) {
        this.nome = nome;
    }
}

public String getNome() {
    return nome;
}

public void setCentro(Ponto centro) {
    this.centro = centro;
}

public Ponto getCentro() {
    return centro;
}

public void setRaio(int raio) {
    this.raio = raio;
}

public double getRaio() {
    return raio;
}

public double calculaDiametro() {
    return 2 * raio;
}

public double calculaArea() {
    return Math.PI * raio * raio;
}

public double calculaPerimetro() {
    return 2 * Math.PI * raio;
}

public void layout() {
    System.out.println("Dados do círculo de raio " + raio);
    System.out.println("Diâmetro do círculo: " + calculaDiametro());
    System.out.println("Área do círculo: " + calculaArea());
    System.out.println("Perímetro do círculo: " + calculaPerimetro());
}
}