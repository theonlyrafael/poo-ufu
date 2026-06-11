package exercicio1;

public class Triangulo {
    int lado1;
    int lado2;
    int lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public void Lado1(int lado1) {
        this.lado1 = lado1;
    }

    public void Lado2(int lado2) {
        this.lado2 = lado2;
    }

    public void Lado3(int lado3) {
        this.lado3 = lado3;
    }

    public int retornaLado1() {
        return lado1;
    }

    public int retornaLado2() {
        return lado2;
    }

    public int retornaLado3() {
        return lado3;
    }

    public int calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    public String tipoTriangulo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            return "Isóscele";
        } else {
            return "Escaleno";
        }
    }
}
