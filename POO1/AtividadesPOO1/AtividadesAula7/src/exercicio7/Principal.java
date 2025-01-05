package exercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class Principal {

    private static String caminhoArq = ".\\data";

    public static ArrayList<Empregado> carregaDados(String caminho) {
        ArrayList<Empregado> e = new ArrayList<>();

        File dir = new File(caminho);

        if (!dir.exists()) {
            dir.mkdirs(); // Cria o diretório se não existir
        }

        if (dir.isDirectory()) {
            File[] arquivos = dir.listFiles();
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                            String linha;
                            while ((linha = leitor.readLine()) != null) {
                                String[] partes = linha.split(" \\| \\| \\| ");
                                if (partes.length == 3) {
                                    String cpf = partes[0];
                                    int idade = Integer.parseInt(partes[1]);
                                    float salario = Float.parseFloat(partes[2]);
                                    e.add(new Empregado(cpf, idade, salario));
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }

        return e;
    }

    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empregado> e = carregaDados(caminhoArq);
        if (e == null)
            e = new ArrayList<>();
        int op = -1;
        String cpf;
        float salario;

        do {
            System.out.println("*** EMPRESA ***");
            System.out.println("1. Inserir");
            System.out.println("2. Exibir Funcionarios");
            System.out.println("3. Buscar por CPF");
            System.out.println("4. Verificar Salario");
            System.out.println("5. Ordenar");
            System.out.println("6. Sair");
            System.out.println("OPÇAO: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("CADASTRAR");
                    System.out.println("Cpf: ");
                    cpf = sc.next();
                    sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    System.out.print("Salario: ");
                    salario = sc.nextFloat();
                    for (int i = 0; i < e.size(); i++) {
                        if (e.get(i).getCpf().equals(cpf)) {
                            e.set(i, new Empregado(cpf, idade, salario));
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("EXIBIR FUNCIONÁRIOS");
                    if (e.isEmpty()) {
                        System.out.println("Não existem funcionários cadastrados.");
                    } else {
                        for (Empregado emp : e) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 3:
                    System.out.println("BUSCAR FUNCIONÁRIO POR CPF");
                    System.out.print("Digite o CPF do funcionário a ser encontrado: ");
                    cpf = sc.next();
                    boolean encontrado = false;
                    for (Empregado emp : e) {
                        if (emp.getCpf().equals(cpf)) {
                            System.out.println("Funcionário encontrado:\n" + emp);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("VERIFICAR SALARIO");
                    System.out.println("Salario: ");
                    salario = sc.nextFloat();
                    for (Empregado emp : e) {
                        if (emp.getSalario() >= salario)
                            System.out.println(emp);
                    }
                    break;

                case 5:
                    Collections.sort(e);
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        Empregado emp = (Empregado) it.next();
                        System.out.println(emp.toString());
                    }
                    break;

                case 6:
                    for (Empregado emp : e) {
                        emp.salvarTexto(caminhoArq);
                        System.out.println("Salvando empregado " + emp.getCpf() + "...");
                    }

            }
        } while (op != 6);
    }
}
