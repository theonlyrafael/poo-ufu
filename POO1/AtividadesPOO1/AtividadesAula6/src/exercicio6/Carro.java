package exercicio6;

public class Carro implements Veículo {
    private String marca;
    private String modelo;
    private String cor;
    private double potencia;

    public Carro(String marca, String modelo, String cor, double potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.potencia = potencia;
    }

    @Override
    public String marca() {
        return marca;
    }

    @Override
    public String modelo() {
        return modelo;
    }

    @Override
    public String cor() {
        return cor;
    }

    @Override
    public double potencia() {
        return potencia;
    }

    @Override
    public void mostraDados() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cor: " + cor);
        System.out.println("Potência: " + potencia);
    }
}