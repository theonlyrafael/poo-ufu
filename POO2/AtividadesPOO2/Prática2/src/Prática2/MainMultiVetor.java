package Prática2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainMultiVetor {
    public static void main(String[] args) {
        int tamanhoVetor = 1000;
        double[] vetor = new double[tamanhoVetor];
        double escalar = 2.0; 

        for (int i = 0; i < tamanhoVetor; i++) {
            vetor[i] = i + 1;
        }

        int numThreads = 10;
        int elementosPorThread = tamanhoVetor / numThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            int inicio = i * elementosPorThread;
            int fim = (i + 1) * elementosPorThread;
            executorService.execute(new MultiVetor(vetor, escalar, inicio, fim));
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}
