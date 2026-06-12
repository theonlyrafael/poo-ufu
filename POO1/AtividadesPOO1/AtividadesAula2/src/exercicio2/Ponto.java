package exercicio2;

public class Ponto {
    private double cX;
    private double cY;

    public Ponto() {
        this.cX = x;
        this.cY = y;
    }

    public void iniciarCoordenadas(double cordX, double cordY) {
        if (cordX > 0) {
            cX = cordX;
        } else {
            cX = 0;
        }
        if (cordY > 0) {
            cY = cordY;
        } else {
            cY = 0;
        }
    }

    public double calculaDistancia(Ponto p) {
        double disX = cX - p.cX;
        double disY = cY - p.cY;
        return Math.sqrt(disX * disX + disY * disY);
    }

    public void alteraPonto(double x, double y) {
        cX = x;
        cY = y;
    }

    public String retPonto() {
        return "O ponto eh: (" + this.cX + "," + this.cY + ")";
    }
}
