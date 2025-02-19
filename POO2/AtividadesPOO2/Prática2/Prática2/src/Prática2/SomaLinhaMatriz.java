package Prática2;

class SomaLinhaMatriz implements Runnable {
    private Matriz matriz;
    private int linha;
    private int resultado;

    public SomaLinhaMatriz(Matriz matriz, int linha) {
        this.matriz = matriz;
        this.linha = linha;
        this.resultado = 0;
    }

    @Override
    public void run() {
        int colunas = matriz.getColunas();
        for (int j = 0; j < colunas; j++) {
            resultado += matriz.getElemento(linha, j);
        }
    }

    public int getResultado() {
        return resultado;
    }
}
