package exercicio5;

public class Circulo extends FormaBidimensional {
    protected float raio;

    public Circulo(String id, String cor, float x, float y, float raio) {
        super(id, cor, x, y);
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public double obterArea() {
        return Math.PI*(raio*raio);
    }

    public boolean intercepta(Circulo outroCirculo) {
        double distanciaCentros = Math.sqrt(Math.pow(this.cX - outroCirculo.cX, 2) + Math.pow(this.cY - outroCirculo.cY, 2));
        return distanciaCentros < (this.raio + outroCirculo.raio);
    }
        
}
