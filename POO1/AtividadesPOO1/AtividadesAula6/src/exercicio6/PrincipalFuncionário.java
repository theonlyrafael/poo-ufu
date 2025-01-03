package exercicio6;

/*public class PrincipalFuncionário {
    public static void main(String[] args) {
        Funcionário[] funcionarios = new Funcionário[5];
        
        funcionarios[0] = new Assistente("João", "A001", 3000.0);
        funcionarios[1] = new Assistente("Maria", "A002", 2800.0);
        funcionarios[2] = new Assistente("Pedro", "A003", 3200.0);
        funcionarios[3] = new Gerente("Lucas", "G001", 5000.0);
        funcionarios[4] = new Vendedor("Ana", "V001", 2500.0, 800.0);
        
        double folhaSalarialTotal = 0.0;
        double somaSalarioAssistente = 0.0;
        double somaSalarioGerente = 0.0;
        double somaSalarioVendedor = 0.0;
        int countAssistente = 0;
        int countGerente = 0;
        int countVendedor = 0;

        for (Funcionário funcionario : funcionarios) {
            double salario = funcionario.calculaSalario();
            folhaSalarialTotal += salario;

            if (funcionario instanceof Assistente) {
                somaSalarioAssistente += salario;
                countAssistente++;
            } else if (funcionario instanceof Gerente) {
                somaSalarioGerente += salario;
                countGerente++;
            } else if (funcionario instanceof Vendedor) {
                somaSalarioVendedor += salario;
                countVendedor++;
            }
        }

        System.out.println("Folha Salarial Total: " + folhaSalarialTotal);
        System.out.println("Média Salarial dos Assistentes: " + (somaSalarioAssistente / countAssistente));
        System.out.println("Média Salarial dos Gerentes: " + (somaSalarioGerente / countGerente));
        System.out.println("Média Salarial dos Vendedores: " + (somaSalarioVendedor / countVendedor));
    }
}*/

import java.util.ArrayList;

public class PrincipalFuncionário {
    public static void main(String[] args) {
        ArrayList<Funcionário> funcionarios = new ArrayList<>();

        funcionarios.add(new Assistente("João", "A001", 3000.0));
        funcionarios.add(new Assistente("Maria", "A002", 2800.0));
        funcionarios.add(new Assistente("Pedro", "A003", 3200.0));
        funcionarios.add(new Gerente("Lucas", "G001", 5000.0));
        funcionarios.add(new Vendedor("Ana", "V001", 2500.0, 800.0));

        double folhaSalarialTotal = 0.0;
        double somaSalarioAssistente = 0.0;
        double somaSalarioGerente = 0.0;
        double somaSalarioVendedor = 0.0;
        int countAssistente = 0;
        int countGerente = 0;
        int countVendedor = 0;

        for (Funcionário funcionario : funcionarios) {
            double salario = funcionario.calculaSalario();
            folhaSalarialTotal += salario;

            if (funcionario instanceof Assistente) {
                somaSalarioAssistente += salario;
                countAssistente++;
            } else if (funcionario instanceof Gerente) {
                somaSalarioGerente += salario;
                countGerente++;
            } else if (funcionario instanceof Vendedor) {
                somaSalarioVendedor += salario;
                countVendedor++;
            }
        }

        System.out.println("Folha Salarial Total: " + folhaSalarialTotal);
        System.out.println("Média Salarial dos Assistentes: " + (somaSalarioAssistente / countAssistente));
        System.out.println("Média Salarial dos Gerentes: " + (somaSalarioGerente / countGerente));
        System.out.println("Média Salarial dos Vendedores: " + (somaSalarioVendedor / countVendedor));
    }
}
