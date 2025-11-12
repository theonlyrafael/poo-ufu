public class QuickSort <T extends Comparable<? super T>> extends Thread {
    private T[] vetor;
    private int inicio;
    private int fim;
    
    // Construtor da classe para a inicialização de objetos
    public QuickSort(T vetor[], int inicio, int fim) {
        this.vetor = vetor;
        this.inicio = inicio;
        this.fim = fim;
    }

    // Método para definir o comportamento da thread
    @Override
    public void run() {
        ordenarQuickSort();
    }
    
    // Ordena o vetor utilizando o algoritmo QuickSort (Divide para conquistar)
    public void ordenarQuickSort() {
        if (inicio < fim) {
            int posicaoPivo = particionar(vetor, inicio, fim); // Encontra a posição do pivo para dividir o vetor
    
            QuickSort<T> threadEsquerda = new QuickSort<>(vetor, inicio, posicaoPivo - 1); // Um novo objeto que será responsável por executar, através de uma thread, o lado esquerdo do vetor que foi dividido
            QuickSort<T> threadDireita = new QuickSort<>(vetor, posicaoPivo + 1, fim); // Um novo objeto que será responsável por executar, através de uma thread, o lado direito do vetor que foi dividido

            threadEsquerda.start(); // Inicia a thread do lado esquerdo
            threadDireita.start(); // Inicia a thread do lado direito

            try {
                // Aguarda a conclusão das duas threads
                threadEsquerda.join();
                threadDireita.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Realiza a partição do vetor
    private int particionar(T vetor[], int inicio, int fim) {
        T pivo = vetor[fim]; // Pivo é o último elemento do vetor
        int i = (inicio - 1); // Obtém o índice do menor elemento do vetor
    
        for (int j = inicio; j < fim; j++) { // Percorre o vetor
            // Verifica se o elemento atual é menor ou igual ao pivo e, caso seja, realiza a troca
            if (vetor[j].compareTo(pivo) <= 0) {
                i++;
    
                T temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
    
        // Coloca o pivo na posição correta
        T temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;
    
        return i + 1; // Retorna a posição do pivo
    }
}
