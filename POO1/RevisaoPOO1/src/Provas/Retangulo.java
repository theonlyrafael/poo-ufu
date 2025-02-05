package Provas;

public class Retangulo {
    private int altura, base;

    public Retângulo(int altura, int base) {
        this.altura = altura;
        this.base = base;
    }
    
    public int getAltura() {
        return altura;
    }

    public int getBase() {
        return base;
    }

    public int calculaArea() {
        return base*altura;
    }

    public int calculaPerimetro(int lado) {
        if (base!=altura) {
            lado = base*2 + altura*2;
        }
        return lado;
    }
}
