package Prática2;

public class Matriz2 {
    private int[][] matriz;

    public Matriz2(int[][] matriz) {
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

    public Matriz2 inverterLinhas() {
        int linhas = getLinhas();
        int colunas = getColunas();
        int[][] novaMatriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                novaMatriz[i][j] = getElemento(i, colunas - 1 - j);
            }
        }

        return new Matriz2(novaMatriz);
    }
}
