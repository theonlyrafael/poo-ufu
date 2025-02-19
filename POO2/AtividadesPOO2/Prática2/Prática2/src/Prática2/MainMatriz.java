package Prática2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMatriz {

    public static void main(String[] args) {
        int[][] matrizValores = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        Matriz matriz = new Matriz(matrizValores);
        int linhas = matriz.getLinhas();

        ExecutorService executorService = Executors.newFixedThreadPool(linhas);

        SomaLinhaMatriz[] runnables = new SomaLinhaMatriz[linhas];

        for (int i = 0; i < linhas; i++) {
            runnables[i] = new SomaLinhaMatriz(matriz, i);
            executorService.execute(runnables[i]);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        for (int i = 0; i < linhas; i++) {
            System.out.println("Soma da linha " + (i + 1) + ": " + runnables[i].getResultado());
        }
    }
}