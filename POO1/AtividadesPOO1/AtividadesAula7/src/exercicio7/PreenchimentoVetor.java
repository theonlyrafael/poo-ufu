package exercicio7;

import java.util.Scanner;

public class PreenchimentoVetor {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Inserir valor no vetor");
                System.out.println("2. Encerrar");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.print("Informe a posição (0-9) ou -1 para encerrar: ");
                    int posicao = scanner.nextInt();

                    if (posicao == -1) {
                        break; // Encerra o loop
                    } else if (posicao < 0 || posicao >= 10) {
                        System.out.println("Posição inválida. Informe um valor entre 0 e 9.");
                    } else {
                        System.out.print("Informe o valor a ser inserido: ");
                        if (scanner.hasNextInt()) {
                            int valor = scanner.nextInt();
                            vetor[posicao] = valor;
                            System.out.println("Valor inserido com sucesso!");
                        } else {
                            System.out.println("Erro: Informação não numérica fornecida. Tente novamente.");
                            scanner.next(); // Limpa o buffer de entrada
                        }
                    }
                } else if (opcao == 2) {
                    break; // Encerra o loop
                } else {
                    System.out.println("Opção inválida. Escolha 1 ou 2.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro: Posição inexistente no vetor. Informe um valor entre 0 e 9.");
            }
        }

        // Exibir o vetor após a inserção
        System.out.println("Valores no vetor:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }

        scanner.close();
    }
}
