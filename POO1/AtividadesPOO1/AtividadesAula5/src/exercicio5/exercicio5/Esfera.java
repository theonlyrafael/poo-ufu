package exercicio5;

public class Esfera extends FormaTridimensional {
    protected float raio;

    public Esfera(String id, String cor, float x, float y, float z, float raio) {
        super(id, cor, x, y, z);
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public double obterVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }

    public boolean intercepta(Esfera outraEsfera) {
        double distanciaCentros = Math.sqrt(Math.pow(this.x - outraEsfera.x, 2) + Math.pow(this.y - outraEsfera.y, 2) + Math.pow(this.z - outraEsfera.z, 2));
        return distanciaCentros < (this.raio + outraEsfera.raio);
    }
    
}

