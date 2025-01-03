package exercicio5;

public class Triangulo extends FormaBidimensional {
    protected float base, altura;

    public Triangulo(String id, String cor, float x, float y, float base, float altura) {
        super(id, cor, x, y);
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }

    public double obterArea() {
        return (base*altura)/2;
    }
    
}
