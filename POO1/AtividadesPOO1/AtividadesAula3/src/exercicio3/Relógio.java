package exercicio3;

import java.util.Scanner;

public class Relógio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        Tempo tempo = new Tempo(16, 20, 59);

        do {
            System.out.println("=====MENU=====");
            System.out.println("[1] Hora formatada em AM ou PM");
            System.out.println("[2] Hora formatada em 24hrs");
            System.out.println("[3] Sair do programa");
            System.out.println("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Hora formatada em AM/PM: " + tempo.formatarTempoCompleto());
                    break;
                case 2:
                    System.out.println("Hora formatada em 24hrs: " + tempo.formatarTempo());
                    break;
                case 3:
                    System.out.println("Saindo do programa. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }

        } while (op != 3);
            sc.close();
        }
    }
    
