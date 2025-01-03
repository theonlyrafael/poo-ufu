package exercicio5;

public class Tetraedro extends FormaTridimensional {
    protected float aresta;

    public Tetraedro(String id, String cor, float x, float y, float z, float aresta) {
        super(id, cor, x, y, z);
        this.aresta = aresta;
    }

    public float getAresta() {
        return aresta;
    }

    public double obterVolume() {
        return (Math.pow(aresta, 3)) / (6 * Math.sqrt(2));
    }
}

