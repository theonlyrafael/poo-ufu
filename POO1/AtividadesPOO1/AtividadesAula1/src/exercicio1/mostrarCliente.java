package exercicio1;

import java.util.*;

public class mostrarCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.next();

        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();

        System.out.print("Digite a idade do cliente: ");
        int idade = scanner.nextInt();

        System.out.print("Digite o telefone do cliente: ");
        String telefone = scanner.next();

        criarCliente cliente = new criarCliente();
        cliente.cadastrarCliente(nome, cpf, idade, telefone);

        cliente.mostrarDadosCliente();
    }
}
