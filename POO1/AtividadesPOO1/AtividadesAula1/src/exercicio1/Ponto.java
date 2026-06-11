package exercicio1;

public class Ponto {
    private double x;
    private double y;

    public void inicializarCoordenadas(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcularDistancia(Ponto ponto) {
        double distanciaX = Math.pow((ponto.x - this.x), 2);
        double distanciaY = Math.pow((ponto.y - this.y), 2);
        return Math.sqrt(distanciaX + distanciaY);
    }
}
