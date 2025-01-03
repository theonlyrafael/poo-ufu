package exercicio5;

public class Quadrado extends FormaTridimensional {
    protected float lado;

    public Quadrado(String id, String cor, float x, float y, float lado) {
        super(id, cor, x, y, lado);
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public float obterArea() {
        return lado*lado;
    }
    
}
