package exercicio7;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static String caminhoArq = ".\\data";

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Empregado> mapaEmpregados = new HashMap<>();

        // Adicione 5 empregados iniciais (você pode usar dados fictícios)
        mapaEmpregados.put("11111111111", new Empregado("11111111111", 25, 4000.0f));
        mapaEmpregados.put("22222222222", new Empregado("22222222222", 30, 4500.0f));
        mapaEmpregados.put("33333333333", new Empregado("33333333333", 28, 3800.0f));
        mapaEmpregados.put("44444444444", new Empregado("44444444444", 35, 5000.0f));
        mapaEmpregados.put("55555555555", new Empregado("55555555555", 32, 4200.0f));

        int op = -1;

        do {
            System.out.println("*** EMPRESA ***");
            System.out.println("1. Inserir");
            System.out.println("2. Exibir Funcionarios");
            System.out.println("3. Buscar por CPF");
            System.out.println("4. Verificar Salario");
            System.out.println("5. CPF do Empregado com Menor e Maior Salário");
            System.out.println("6. Sair");
            System.out.print("OPÇÃO: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("CADASTRAR");
                    System.out.print("CPF: ");
                    String cpf = sc.next();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    System.out.print("Salario: ");
                    float salario = sc.nextFloat();

                    Empregado empregado = new Empregado(cpf, idade, salario);
                    mapaEmpregados.put(cpf, empregado);
                    break;

                case 2:
                    System.out.println("EXIBIR FUNCIONÁRIOS");
                    if (mapaEmpregados.isEmpty()) {
                        System.out.println("Não existem funcionários cadastrados.");
                    } else {
                        for (Empregado emp : mapaEmpregados.values()) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 3:
                    System.out.println("BUSCAR FUNCIONÁRIO POR CPF");
                    System.out.print("Digite o CPF do funcionário a ser encontrado: ");
                    String cpfBusca = sc.next();
                    Empregado empregadoBuscado = mapaEmpregados.get(cpfBusca);

                    if (empregadoBuscado != null) {
                        System.out.println("Funcionário encontrado:\n" + empregadoBuscado);
                    } else {
                        System.out.println("Funcionário com CPF " + cpfBusca + " não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("VERIFICAR SALARIO");
                    System.out.print("Salario: ");
                    float salarioLimite = sc.nextFloat();

                    for (Empregado emp : mapaEmpregados.values()) {
                        if (emp.getSalario() >= salarioLimite)
                            System.out.println(emp);
                    }
                    break;

                case 5:
                    float menorSalario = Float.MAX_VALUE;
                    float maiorSalario = Float.MIN_VALUE;
                    String cpfMenorSalario = null;
                    String cpfMaiorSalario = null;

                    for (Empregado emp : mapaEmpregados.values()) {
                        float salarioEmp = emp.getSalario();
                        if (salarioEmp < menorSalario) {
                            menorSalario = salarioEmp;
                            cpfMenorSalario = emp.getCpf();
                        }
                        if (salarioEmp > maiorSalario) {
                            maiorSalario = salarioEmp;
                            cpfMaiorSalario = emp.getCpf();
                        }
                    }

                    System.out.println("CPF do empregado com menor salário: " + cpfMenorSalario);
                    System.out.println("CPF do empregado com maior salário: " + cpfMaiorSalario);
                    break;

                case 6:
                    for (Empregado emp : mapaEmpregados.values()) {
                        emp.salvarTexto(caminhoArq);
                        System.out.println("Salvando empregado " + emp.getCpf() + "...");
                    }
                    break;
            }
        } while (op != 6);
    }
}
