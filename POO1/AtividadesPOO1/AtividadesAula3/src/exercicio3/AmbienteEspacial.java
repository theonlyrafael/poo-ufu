package exercicio3;

import java.util.Scanner;

public class AmbienteEspacial {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        NaveEspacial vetNaves[] = new NaveEspacial[5];
        NaveEspacial vetNvOp[] = new NaveEspacial[5];
        NaveEspacial vetNvInop[] = new NaveEspacial[5];
        int numNaves = 0, pos = 0, pos2 = 0, numNvOp = 0, numNvInop = 0;

        int opc1;

        do {

            System.out.println(
                    "----MENU---\r\n[1]Criar uma nova nave\r\n[2]Exibir naves existentes\r\n[3]Parar nave\r\n[4]Ligar nave\r\n[5]Comparar velocidade de naves\r\n[0]Sair\r\n");
            opc1 = sc.nextInt();

            switch (opc1) {
                case 1:
                    if (numNaves < 5) {
                        System.out.println("Digite o nome da nave: ");
                        String n = sc.next();
                        NaveEspacial ne = new NaveEspacial(n);
                        numNaves++;
                        vetNaves[pos] = ne;
                        vetNvOp[pos] = vetNaves[pos];
                        pos++;
                        numNvOp++;
                        System.out.println("Nave criada com sucesso.\r\n");
                    } else {
                        System.out.println("Nao foi possivel criar. Número máximo de naves já atingido.\r\n");
                    }
                    break;
                case 2:
                    for (int i = 0; i < numNaves; i++) {
                        if (vetNaves[i].getVel() == 0) {
                            System.out.println("Nave[" + (i + 1) + "] inoperante.\r\n");
                        } else {
                            System.out.println("Nave[" + (i + 1) + "]: " + vetNaves[i].mostrarNave());
                        }
                    }
                    break;
                case 3:
                    int op1;

                    System.out.println("\r\nAs naves operantes são:");
                    for (int i = 0; i < numNaves; i++) {
                        System.out.println("Nave[" + (i + 1) + "]: " + vetNvOp[i].mostrarNave());
                    }
                    System.out.print("\r\nDigite o número da nave que deseja parar: ");
                    op1 = sc.nextInt();
                    vetNvOp[op1 - 1].pararNave();
                    vetNvInop[pos2] = vetNvOp[op1 - 1];
                    pos2++;
                    numNvOp--;
                    numNvInop++;

                    System.out.println("Nave parada com sucesso.");
                    break;
                case 4:
                    int op2, cont = 0;

                    for (int i = 0; i < numNaves; i++) {
                        if (vetNaves[i].getVel() != 0) {
                            cont++;
                        }
                    }

                    if (cont > 3) {
                        System.out.println("Superpopulacão de Naves.");
                        break;
                    } else {
                        System.out.println("\r\nAs naves inoperantes são:");
                        for (int j = 0; j < numNvInop; j++) {
                            System.out.println("Nave[" + (j + 1) + "]: " + vetNvInop[j].mostrarNave());
                        }
                        System.out.print("\r\nDigite o número da nave que deseja ligar: ");
                        op2 = sc.nextInt();
                        System.out.print("Agora, a velocidade da nave: ");
                        int v = sc.nextInt();
                        vetNvInop[op2 - 1].ligarNave(v);
                        numNvOp++;
                        numNvInop--;
                        System.out.println("Nave ligada com sucesso.");
                    }
                    break;
                case 5:
                    int n1, n2;
                    System.out.println("As naves são:\r\n");
                    for (int i = 0; i < numNaves; i++) {
                        System.out.println("Nave[" + (i + 1) + "]: " + vetNaves[i].getNome());
                    }
                    System.out.print("Digite o índice da nave que deseja comparar:");
                    n1 = sc.nextInt();
                    System.out.print("Agora o índice da outra nave:");
                    n2 = sc.nextInt();

                    System.out.println(vetNaves[n1 - 1].naveMaisRapida(vetNaves[n2 - 1]));

                    break;
                case 0:
                    System.out.println("Saindooo...");
                    break;
            }
        } while (opc1 != 0);
    }
}