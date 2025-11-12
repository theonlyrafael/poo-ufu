public class Main {
    public static void main(String[] args) throws Exception {
        // Array de strings com os nomes
        String[] arrayDePessoas = { "Carlos", "Mariana", "Ricardo", "Larissa", "Vinícius", "Fernanda", "Gabriel",
                "Luciana",
                "Roberto", "Cristina", "Fernando", "Amanda", "Lucas", "Isabela", "Pedro", "Camila", "Renato", "Natália",
                "Anderson", "Bianca" };

        // Array de inteiros
        Integer[] arrayDeNumeros = { 50, 92, 31, 74, 22, 88, 63, 11, 45, 230, 12, 135, 97, 109, 246, 78 };

        // Instanciando um objeto da classe QuickSort
        QuickSort<Integer> ordenacao = new QuickSort<>(arrayDeNumeros, 0, arrayDeNumeros.length - 1);

        // Iniciando a thread
        ordenacao.start();

        try {
            // Aguarda a thread terminar
            ordenacao.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimindo na tela o vetor ordenado
        System.out.println(java.util.Arrays.toString(arrayDeNumeros));

        // Instanciando um objeto da classe QuickSort para ordenar o vetor de pessoas
        QuickSort<String> ordenacaoPessoas = new QuickSort<>(arrayDePessoas, 0, arrayDePessoas.length - 1);

        // Iniciando a thread para ordenar o vetor de pessoas
        ordenacaoPessoas.start();

        try {
            // Aguarda a thread terminar
            ordenacaoPessoas.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimindo na tela o vetor ordenado de pessoas
        System.out.println("Vetor de Pessoas Ordenado: " + java.util.Arrays.toString(arrayDePessoas));
    }
}
