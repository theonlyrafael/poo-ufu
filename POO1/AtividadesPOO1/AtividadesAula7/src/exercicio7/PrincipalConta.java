package exercicio7;

import java.util.Scanner;

public class PrincipalConta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conta[] contas = new Conta[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Conta " + (i + 1));
            System.out.print("Nome do titular da conta: ");
            String nome = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double saldo = sc.nextDouble();
            sc.nextLine();

            contas[i] = new Conta(nome, saldo, i + 1);
        }

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Visualizar saldo");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    realizarDeposito(contas, sc);
                    break;
                case 2:
                    realizarSaque(contas, sc);
                    break;
                case 3:
                    visualizarSaldo(contas, sc);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void realizarDeposito(Conta[] contas, Scanner scanner) {
        System.out.print("Informe o número da conta para depósito: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Informe o valor a ser depositado: ");
        double valorDeposito = scanner.nextDouble();

        try {
            contas[numeroConta - 1].depositar(valorDeposito);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Número de conta inválido.");
        }
    }

    private static void realizarSaque(Conta[] contas, Scanner scanner) {
        System.out.print("Informe o número da conta para saque: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Informe o valor a ser sacado: ");
        double valorSaque = scanner.nextDouble();

        try {
            contas[numeroConta - 1].sacar(valorSaque);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Número de conta inválido.");
        }
    }

    private static void visualizarSaldo(Conta[] contas, Scanner scanner) {
        System.out.print("Informe o número da conta para visualizar o saldo: ");
        int numeroConta = scanner.nextInt();

        try {
            double saldo = contas[numeroConta - 1].getSaldo();
            String nome = contas[numeroConta - 1].getNome();
            System.out.println("Saldo atual da conta de " + nome + ": R$" + saldo);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Número de conta inválido.");
        }
    }
}
