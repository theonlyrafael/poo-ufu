package exercicio5;

import java.util.Scanner;

public class FuncionarioPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[10];

        int opcao;
        int posicao = 0; 

        do {
            System.out.println("Menu:");
            System.out.println("1) Cadastrar Funcionário Comissionado");
            System.out.println("2) Cadastrar Funcionário Noturno");
            System.out.println("3) Pesquisar Funcionário");
            System.out.println("4) Quantidade de Funcionários por Categoria");
            System.out.println("5) Maior Salário por Categoria");
            System.out.println("6) Folha de Pagamentos");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    if (posicao < funcionarios.length) {
                        System.out.print("Informe a matrícula: ");
                        int matricula = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Informe a idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Informe o nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Informe o CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Informe o salário base: ");
                        float salarioBase = sc.nextFloat();
                        System.out.print("Informe a comissão: ");
                        float comissao = sc.nextFloat();

                        funcionarios[posicao] = new FuncionarioComissionado(matricula, idade, nome, cpf, salarioBase,
                                comissao);
                        posicao++;
                        System.out.println("Funcionário Comissionado cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de funcionários atingido.");
                    }
                    break;

                case 2:
                    if (posicao < funcionarios.length) {
                        System.out.print("Informe a matrícula: ");
                        int matricula = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Informe a idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine(); 
                        System.out.print("Informe o nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Informe o CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Informe o salário base: ");
                        float salarioBase = sc.nextFloat();
                        System.out.print("Informe o número de noites trabalhadas: ");
                        int noitesTrabalhadas = sc.nextInt();

                        funcionarios[posicao] = new FuncionarioNoturno(matricula, idade, nome, cpf, noitesTrabalhadas);
                        posicao++;
                        System.out.println("Funcionário Noturno cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de funcionários atingido.");
                    }
                    break;

                case 3:
                    System.out.print("Pesquisar por CPF ou Matrícula (CPF/Matrícula): ");
                    String busca = sc.nextLine();
                    System.out.println("Resultados da Pesquisa:");
                    for (int i = 0; i < posicao; i++) {
                        Funcionario funcionario = funcionarios[i];
                        if (funcionario.getCPF().equals(busca)
                                || Integer.toString(funcionario.getMatricula()).equals(busca)) {
                            System.out.println("Matrícula: " + funcionario.getMatricula());
                            System.out.println("Nome: " + funcionario.getNome());
                            System.out.println("CPF: " + funcionario.getCPF());
                            System.out.println("Idade: " + funcionario.getIdade());
                            System.out.println("Salário: " + funcionario.getSalario());
                            if (funcionario instanceof FuncionarioComissionado) {
                                System.out.println("Categoria: Comissionado");
                                System.out.println("Comissão: " + ((FuncionarioComissionado) funcionario).getComissao());
                            } else if (funcionario instanceof FuncionarioNoturno) {
                                System.out.println("Categoria: Noturno");
                                System.out.println("Noites Trabalhadas: "
                                        + ((FuncionarioNoturno) funcionario).getNoitesTrabalhadas());
                            }
                            System.out.println("-------------------------");
                        }
                    }
                    break;

                case 4:
                    int contadorComissionado = 0;
                    int contadorNoturno = 0;
                    for (int i = 0; i < posicao; i++) {
                        if (funcionarios[i] instanceof FuncionarioComissionado) {
                            contadorComissionado++;
                        } else if (funcionarios[i] instanceof FuncionarioNoturno) {
                            contadorNoturno++;
                        }
                    }
                    System.out.println("Quantidade de Funcionários Comissionados: " + contadorComissionado);
                    System.out.println("Quantidade de Funcionários Noturnos: " + contadorNoturno);
                    break;

                case 5:
                    float maiorSalarioComissionado = 0;
                    float maiorSalarioNoturno = 0;
                    for (int i = 0; i < posicao; i++) {
                        Funcionario funcionario = funcionarios[i];
                        if (funcionario instanceof FuncionarioComissionado) {
                            float salario = funcionario.getSalario();
                            if (salario > maiorSalarioComissionado) {
                                maiorSalarioComissionado = salario;
                            }
                        } else if (funcionario instanceof FuncionarioNoturno) {
                            float salario = funcionario.getSalario();
                            if (salario > maiorSalarioNoturno) {
                                maiorSalarioNoturno = salario;
                            }
                        }
                    }
                    System.out.println("Maior Salário de Funcionário Comissionado: " + maiorSalarioComissionado);
                    System.out.println("Maior Salário de Funcionário Noturno: " + maiorSalarioNoturno);
                    break;

                case 6:
                    float totalFolhaPagamentos = 0;
                    System.out.println("Folha de Pagamentos:");
                    for (int i = 0; i < posicao; i++) {
                        Funcionario funcionario = funcionarios[i];
                        totalFolhaPagamentos += funcionario.getSalario();
                        System.out.println("Matrícula: " + funcionario.getMatricula());
                        System.out.println("Nome: " + funcionario.getNome());
                        System.out.println("Salário: " + funcionario.getSalario());
                        if (funcionario instanceof FuncionarioComissionado) {
                            System.out.println("Categoria: Comissionado");
                            System.out.println("Comissão: " + ((FuncionarioComissionado) funcionario).getComissao());
                        } else if (funcionario instanceof FuncionarioNoturno) {
                            System.out.println("Categoria: Noturno");
                            System.out.println(
                                    "Noites Trabalhadas: " + ((FuncionarioNoturno) funcionario).getNoitesTrabalhadas());
                        }
                        System.out.println("-------------------------");
                    }
                    System.out.println("Total da Folha de Pagamentos: " + totalFolhaPagamentos);
                    break;
            }
        } while (opcao != 0);
    }
}
