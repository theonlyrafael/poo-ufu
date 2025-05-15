package Prática2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMatriz2 {

    public static void main(String[] args) {
        int[][] matrizValores = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Matriz2 matriz = new Matriz2(matrizValores);
        int linhas = matriz.getLinhas();

        ExecutorService executorService = Executors.newFixedThreadPool(linhas);

        InverteLinhaMatriz[] runnables = new InverteLinhaMatriz[linhas];

        for (int i = 0; i < linhas; i++) {
            runnables[i] = new InverteLinhaMatriz(matriz, i);
            executorService.execute(runnables[i]);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        for (int i = 0; i < linhas; i++) {
            Matriz2 matrizInvertida = runnables[i].getMatrizResultante();
            for (int j = 0; j < matrizInvertida.getColunas(); j++) {
                System.out.print(matrizInvertida.getElemento(i, j) + " ");
            }
            System.out.println();
        }
    }
}