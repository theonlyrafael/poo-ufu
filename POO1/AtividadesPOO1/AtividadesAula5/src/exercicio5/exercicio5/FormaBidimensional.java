package exercicio5;

public class FormaBidimensional extends Forma {
    protected float cX, cY;

    public FormaBidimensional(String id, String cor, float cX, float cY) {
        super(id, cor);
        this.cX = cX;
        this.cY = cY;
    }

    public float getCX() {
        return cX;
    }

    public float getCY() {
        return cY;
    }
    
    public double obterArea() {
        return 0;
    }
}
