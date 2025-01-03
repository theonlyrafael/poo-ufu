package exercicio5;

public class FormaTridimensional extends Forma {
    public float x, y, z;

    public FormaTridimensional(String id, String cor, float x, float y, float z) {
        super(id, cor);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public double obterVolume() {
        return 0;
    }
}
