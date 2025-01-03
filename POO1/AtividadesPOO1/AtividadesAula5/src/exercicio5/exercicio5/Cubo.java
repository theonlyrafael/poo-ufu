package exercicio5;

public class Cubo extends FormaTridimensional {
    protected float aresta;

    public Cubo(String id, String cor, float x, float y, float z, float aresta) {
        super(id, cor, x, y, z);
        this.aresta = aresta;
    }

    public float getAresta() {
        return aresta;
    }

    public double obterVolume() {
        return Math.pow(aresta, 3);
    }
}

