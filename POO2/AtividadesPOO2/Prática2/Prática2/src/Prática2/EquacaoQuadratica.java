package Prática2;

public class EquacaoQuadratica {
    public double a;
    public double b;
    public double c;

    public EquacaoQuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public static double calcularDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double[] calcularRaizes(double a, double b, double c) {
        double delta = calcularDelta(a, b, c);

        if (delta < 0) {
            return new double[]{};
        } else if (delta == 0) {
            double raiz = -b / (2 * a);
            return new double[]{raiz};
        } else {
            double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{raiz1, raiz2};
        }
    }
}
