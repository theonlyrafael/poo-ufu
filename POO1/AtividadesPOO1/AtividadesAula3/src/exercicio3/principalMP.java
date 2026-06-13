package exercicio3;

import java.util.*;

public class principalMP {
    public static void main(String[] args) {
        máquinadepassagens máquina = new máquinadepassagens(10);
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Inserir dinheiro");
            System.out.println("2. Mostrar preço da passagem");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade de dinheiro: ");
                    int quantDinheiro = sc.nextInt();
                    máquina.inserirDinheiro(quantDinheiro);
                    break;
                case 2:
                    máquina.mostrarPreco();
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (opcao != 3);
    }
}