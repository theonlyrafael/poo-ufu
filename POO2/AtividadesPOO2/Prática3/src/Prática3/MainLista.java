package Prática3;

import java.util.stream.IntStream;

public class MainLista {
    private static final int TAMANHO_VETOR = 5;

    public static void main(String[] args) {

        int[] vetor = new int[TAMANHO_VETOR];
        for (int i = 0; i < TAMANHO_VETOR; i++) {
            vetor[i] = i;
        }

        ListaEncadeada lista = new ListaEncadeada();

        Thread[] threads = new Thread[TAMANHO_VETOR];
        int[] indices = IntStream.range(0, TAMANHO_VETOR).toArray();
        for (int i = 0; i < TAMANHO_VETOR; i++) {
            int indice = indices[i];
            threads[i] = new Thread(() -> {
                lista.adicionar(vetor[indice]);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Lista encadeada:");
        lista.imprimir();
    }
}
