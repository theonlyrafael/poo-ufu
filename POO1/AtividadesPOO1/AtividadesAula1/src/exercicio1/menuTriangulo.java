package exercicio1;

import java.util.*;

public class menuTriangulo {
    private static Triangulo[] triangulos = new Triangulo[10];
    private static int quantidadeTriangulos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU");
            System.out.println("1 - Inserir triângulo");
            System.out.println("2 - Mostrar triângulos cadastrados");
            System.out.println("3 - Mostrar o número de triângulos equiláteros");
            System.out.println("4 - Mostrar o triângulo cadastrado com maior perímetro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    inserirTriangulo(sc);
                    break;
                case 2:
                    mostrarTriangulos();
                    break;
                case 3:
                    mostrarNumeroTriangulosEquilateros();
                    break;
                case 4:
                    mostrarTrianguloMaiorPerimetro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    public static void inserirTriangulo(Scanner sc) {
        if (quantidadeTriangulos < 10) {
            System.out.println("Digite o lado 1 do triângulo: ");
            int lado1 = sc.nextInt();

            System.out.println("Digite o lado 2 do triângulo: ");
            int lado2 = sc.nextInt();

            System.out.println("Digite o lado 3 do triângulo: ");
            int lado3 = sc.nextInt();

            Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
            triangulos[quantidadeTriangulos] = triangulo;
            quantidadeTriangulos++;

            System.out.println("Triângulo cadastrado com sucesso!");
        } else {
            System.out.println("Limite de triângulos cadastrados atingido!");
        }
    }

    public static void mostrarTriangulos() {
        System.out.println("Triângulos cadastrados:");
        for (int i = 0; i < quantidadeTriangulos; i++) {
            Triangulo triangulo = triangulos[i];
            System.out.println("Lado 1: " + triangulo.retornaLado1());
            System.out.println("Lado 2: " + triangulo.retornaLado2());
            System.out.println("Lado 3: " + triangulo.retornaLado3());
            System.out.println("Tipo: " + triangulo.tipoTriangulo());
            System.out.println("Perímetro: " + triangulo.calcularPerimetro());
            System.out.println("---");
        }
    }

    public static void mostrarNumeroTriangulosEquilateros() {
        int quantidadeEquilateros = 0;

        for (int i = 0; i < quantidadeTriangulos; i++) {
            Triangulo triangulo = triangulos[i];
            if (triangulo.tipoTriangulo().equals("Equilátero")) {
                quantidadeEquilateros++;
            }
        }

        System.out.println("Número de triângulos equiláteros: " + quantidadeEquilateros);
    }

    public static void mostrarTrianguloMaiorPerimetro() {
        if (quantidadeTriangulos > 0) {
            Triangulo trianguloMaiorPerimetro = triangulos[0];

            for (int i = 1; i < quantidadeTriangulos; i++) {
                Triangulo triangulo = triangulos[i];
                if (triangulo.calcularPerimetro() > trianguloMaiorPerimetro.calcularPerimetro()) {
                    trianguloMaiorPerimetro = triangulo;
                }
            }
            

            System.out.println("Triângulo com maior perímetro:");
            System.out.println("Lado 1: " + trianguloMaiorPerimetro.retornaLado1());
            System.out.println("Lado 2: " + trianguloMaiorPerimetro.retornaLado2());
            System.out.println("Lado 3: " + trianguloMaiorPerimetro.retornaLado3());
            System.out.println("Tipo: " + trianguloMaiorPerimetro.tipoTriangulo());
            System.out.println("Perímetro: " + trianguloMaiorPerimetro.calcularPerimetro());
        } else {
            System.out.println("Nenhum triângulo foi cadastrado");
        }
    }
}