package exercicio4;

import java.util.Scanner;

public class MainMidia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DVD[] dvds = new DVD[5];
        CD[] cds = new CD[5];
        FitaVHS[] fitasVHS = new FitaVHS[5];

        int dvdCount = 0;
        int cdCount = 0;
        int vhsCount = 0;
        int op;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar DVD");
            System.out.println("2. Adicionar CD");
            System.out.println("3. Adicionar Fita VHS");
            System.out.println("4. Listar DVDs");
            System.out.println("5. Listar CDs");
            System.out.println("6. Listar Fitas VHS");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (dvdCount < 5) {
                        System.out.print("Nome do DVD: ");
                        String nomeDVD = sc.nextLine();
                        System.out.print("Gênero do DVD: ");
                        String generoDVD = sc.nextLine();
                        System.out.print("Preço de locação do DVD: ");
                        double precoDVD = sc.nextDouble();
                        sc.nextLine(); // Limpar o buffer

                        System.out.print("Diretor do DVD: ");
                        String diretor = sc.nextLine();
                        System.out.print("Duração do DVD (minutos): ");
                        int duracao = sc.nextInt();
                        sc.nextLine(); // Limpar o buffer

                        System.out.print("Número de atores: ");
                        int numAtores = sc.nextInt();
                        sc.nextLine(); // Limpar o buffer
                        String[] atores = new String[numAtores];
                        for (int i = 0; i < numAtores; i++) {
                            System.out.print("Nome do ator " + (i + 1) + ": ");
                            atores[i] = sc.nextLine();
                        }

                        dvds[dvdCount] = new DVD(nomeDVD, generoDVD, precoDVD, diretor, duracao, atores);
                        dvdCount++;
                    } else {
                        System.out.println("Limite de DVDs atingido.");
                    }
                    break;
                case 2:
                    if (cdCount < 5) {
                        System.out.print("Nome do CD: ");
                        String nomeCD = sc.nextLine();
                        System.out.print("Gênero do CD: ");
                        String generoCD = sc.nextLine();
                        System.out.print("Preço de locação do CD: ");
                        double precoCD = sc.nextDouble();
                        sc.nextLine(); // Limpar o buffer

                        System.out.print("Cantor do CD: ");
                        String cantor = sc.nextLine();
                        System.out.print("Número de faixas do CD: ");
                        int numeroFaixas = sc.nextInt();
                        sc.nextLine(); // Limpar o buffer

                        cds[cdCount] = new CD(nomeCD, generoCD, precoCD, cantor, numeroFaixas);
                        cdCount++;
                    } else {
                        System.out.println("Limite de CDs atingido.");
                    }
                    break;
                case 3:
                    if (vhsCount < 5) {
                        System.out.print("Nome da Fita VHS: ");
                        String nomeVHS = sc.nextLine();
                        System.out.print("Gênero da Fita VHS: ");
                        String generoVHS = sc.nextLine();
                        System.out.print("Preço de locação da Fita VHS: ");
                        double precoVHS = sc.nextDouble();
                        sc.nextLine(); // Limpar o buffer

                        System.out.print("A fita VHS está rebobinada? (Sim/Não): ");
                        boolean rebobinada = sc.nextLine().equalsIgnoreCase("Sim");

                        fitasVHS[vhsCount] = new FitaVHS(nomeVHS, generoVHS, precoVHS, rebobinada);
                        vhsCount++;
                    } else {
                        System.out.println("Limite de Fitas VHS atingido.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de DVDs:");
                    for (int i = 0; i < dvdCount; i++) {
                        DVD dvd = dvds[i];
                        System.out.println("Nome: " + dvd.getNome());
                        System.out.println("Diretor: " + dvd.getDiretor());
                        System.out.println("Duração: " + dvd.getDuracao() + " minutos");
                        System.out.println("Atores: " + String.join(", ", dvd.getAtores()));
                        System.out.println("Gênero: " + dvd.getGenero());
                        System.out.println("Preço de Locação: " + dvd.getPrecoLocacao());
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.println("Lista de CDs:");
                    for (int i = 0; i < cdCount; i++) {
                        CD cd = cds[i];
                        System.out.println("Nome: " + cd.getNome());
                        System.out.println("Cantor: " + cd.getCantor());
                        System.out.println("Número de Faixas: " + cd.getNumeroFaixas());
                        System.out.println("Gênero: " + cd.getGenero());
                        System.out.println("Preço de Locação: " + cd.getPrecoLocacao());
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Lista de Fitas VHS:");
                    for (int i = 0; i < vhsCount; i++) {
                        FitaVHS fitaVHS = fitasVHS[i];
                        System.out.println("Nome: " + fitaVHS.getNome());
                        System.out.println("Rebobinada: " + (fitaVHS.isRebobinada() ? "Sim" : "Não"));
                        System.out.println("Gênero: " + fitaVHS.getGenero());
                        System.out.println("Preço de Locação: " + fitaVHS.getPrecoLocacao());
                        System.out.println();
                    }
                    break;
                case 7:
                    System.out.println("Saindo do programa.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (op != 7);
    }
}
