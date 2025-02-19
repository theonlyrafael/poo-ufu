package Prática2;

public class Matriz {
    private int[][] matriz;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLinhas() {
        return matriz.length;
    }

    public int getColunas() {
        return matriz[0].length;
    }

    public int getElemento(int i, int j) {
        return matriz[i][j];
    }
}