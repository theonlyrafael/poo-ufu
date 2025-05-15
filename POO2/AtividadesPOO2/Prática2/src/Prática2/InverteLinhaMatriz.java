package Prática2;

public class InverteLinhaMatriz implements Runnable {
    private Matriz2 matriz;
    private int linha;
    private Matriz2 matrizResultante; 

    public InverteLinhaMatriz(Matriz2 matriz, int linha) {
        this.matriz = matriz;
        this.linha = linha;
    }

    @Override
    public void run() {
        matrizResultante = matriz.inverterLinhas();
    }

    public Matriz2 getMatrizResultante() {
        return matrizResultante;
    }
}