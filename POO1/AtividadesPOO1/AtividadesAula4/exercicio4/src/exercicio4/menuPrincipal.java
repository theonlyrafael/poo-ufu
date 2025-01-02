package exercicio4;

import java.util.Scanner;

public class menuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vendedores[] v = new Vendedores[5];
        Administrativo[] a = new Administrativo[5];

        int contadorVendedores = 0;
        int contadorAdministrativos = 0;
        int op;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Vendedor");
            System.out.println("2. Adicionar Administrativo");
            System.out.println("3. Calcular Salário de Todos");
            System.out.println("4. Sair");

             op = sc.nextInt();

            switch (op) {
                case 1:
                    if (contadorVendedores < 5) {
                        System.out.println("Digite o nome do Vendedor:");
                        String nomeVendedor = sc.next();
                        System.out.println("Digite o RG do Vendedor:");
                        String rgVendedor = sc.next();
                        System.out.println("Digite o salário do Vendedor:");
                        float salarioVendedor = sc.nextFloat();
                        v[contadorVendedores] = new Vendedores(nomeVendedor, rgVendedor, salarioVendedor);
                        contadorVendedores++;
                    } else {
                        System.out.println("Limite de Vendedores atingido!");
                    }
                    break;

                case 2:
                    if (contadorAdministrativos < 5) {
                        System.out.println("Digite o nome do Administrativo:");                                                
                        String nomeAdministrativo = sc.next();
                        System.out.println("Digite o RG do Administrativo:");
                        String rgAdministrativo = sc.next();
                        System.out.println("Digite o salário do Administrativo:");
                        float salarioAdministrativo = sc.nextFloat();
                        a[contadorAdministrativos + 5] = new Administrativo(nomeAdministrativo,
                                rgAdministrativo, salarioAdministrativo);
                        contadorAdministrativos++;
                    } else {
                        System.out.println("Limite de Administrativos atingido!");
                    }
                    break;

                case 3:
                    System.out.println("===== CALCULAR SALÁRIO DOS VENDEDORES =====");
                    for (int i = 0; i < contadorVendedores; i++) {
                        float salario = v[i].calculaSalario();
                        System.out.println("Nome: " + v[i].getNome());
                        System.out.println("Salário: " + salario);
                    }
                    break;


                case 4:
                    System.out.println("===== CALCULAR SALÁRIO DOS ADMINISTRATIVOS =====");
                    for (int i = 0; i < contadorAdministrativos; i++) {
                        float salario = a[i].calculaSalario();
                        System.out.println("Nome: " + v[i].getNome());
                        System.out.println("Salário: " + salario);
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");


                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        } while (op != 5);
    } 
}

