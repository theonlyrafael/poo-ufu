package exercicio5;

import java.util.Scanner;

public class FormaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Forma[] vetorFormas = new Forma[100];
        int tamanhoVetor = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("(1) Cadastrar uma forma");
            System.out.println("(2) Mostrar descrição textual de todas as formas cadastradas");
            System.out.println("(3) Mostrar área das formas bidimensionais cadastradas");
            System.out.println("(4) Mostrar volume das formas tridimensionais cadastradas");
            System.out.println("(5) Verificar interseção de duas esferas ou círculos");
            System.out.println("(0) Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarForma(scanner, vetorFormas, tamanhoVetor);
                    tamanhoVetor++;
                    break;
                case 2:
                    mostrarDescricaoFormas(vetorFormas, tamanhoVetor);
                    break;
                case 3:
                    mostrarAreaFormasBidimensionais(vetorFormas, tamanhoVetor);
                    break;
                case 4:
                    mostrarVolumeFormasTridimensionais(vetorFormas, tamanhoVetor);
                    break;
                case 5:
                    verificarIntersecaoEsferasCirculos(vetorFormas, tamanhoVetor);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void cadastrarForma(Scanner scanner, Forma[] vetorFormas, int tamanhoVetor) {
        System.out.println("Escolha o tipo de forma a ser cadastrado:");
        System.out.println("(1) Círculo");
        System.out.println("(2) Quadrado");
        System.out.println("(3) Triângulo");
        System.out.println("(4) Esfera");
        System.out.println("(5) Cubo");
        System.out.println("(6) Tetraedro");

        int tipoForma = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado

        System.out.println("Digite o ID da forma:");
        String id = scanner.nextLine();
        System.out.println("Digite a cor da forma:");
        String cor = scanner.nextLine();

        if (tipoForma >= 1 && tipoForma <= 3) {
            // Formas bidimensionais
            System.out.println("Digite as coordenadas (X e Y) separadas por espaço:");
            float cX = scanner.nextFloat();
            float cY = scanner.nextFloat();

            if (tipoForma == 1) {
                // Círculo
                System.out.println("Digite o raio do círculo:");
                float raio = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Circulo(id, cor, cX, cY, raio);
            } else if (tipoForma == 2) {
                // Quadrado
                System.out.println("Digite o lado do quadrado:");
                float lado = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Quadrado(id, cor, cX, cY, lado);
            } else if (tipoForma == 3) {
                // Triângulo
                System.out.println("Digite a base e a altura do triângulo separadas por espaço:");
                float base = scanner.nextFloat();
                float altura = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Triangulo(id, cor, cX, cY, base, altura);
            }
        } else if (tipoForma >= 4 && tipoForma <= 6) {
            // Formas tridimensionais
            System.out.println("Digite as coordenadas (X, Y e Z) separadas por espaço:");
            float x = scanner.nextFloat();
            float y = scanner.nextFloat();
            float z = scanner.nextFloat();

            if (tipoForma == 4) {
                // Esfera
                System.out.println("Digite o raio da esfera:");
                float raio = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Esfera(id, cor, x, y, z, raio);
            } else if (tipoForma == 5) {
                // Cubo
                System.out.println("Digite o lado do cubo:");
                float lado = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Cubo(id, cor, x, y, z, lado);
            } else if (tipoForma == 6) {
                // Tetraedro
                System.out.println("Digite o lado do tetraedro:");
                float lado = scanner.nextFloat();
                vetorFormas[tamanhoVetor] = new Tetraedro(id, cor, x, y, z, lado);
            }
        } else {
            System.out.println("Opção inválida. Forma não cadastrada.");
        }
    }

    public static void mostrarDescricaoFormas(Forma[] vetorFormas, int tamanhoVetor) {
        System.out.println("Descrição textual de todas as formas cadastradas:");
        for (int i = 0; i < tamanhoVetor; i++) {
            System.out.println(vetorFormas[i].toString());
        }
    }

    public static void mostrarAreaFormasBidimensionais(Forma[] vetorFormas, int tamanhoVetor) {
        System.out.println("Área das formas bidimensionais cadastradas:");
        for (int i = 0; i < tamanhoVetor; i++) {
            if (vetorFormas[i] instanceof FormaBidimensional) {
                FormaBidimensional formaBidimensional = (FormaBidimensional) vetorFormas[i];
                System.out.println("ID: " + formaBidimensional.getID() + ", Área: " + formaBidimensional.obterArea());
            }
        }
    }

    public static void mostrarVolumeFormasTridimensionais(Forma[] vetorFormas, int tamanhoVetor) {
        System.out.println("Volume das formas tridimensionais cadastradas:");
        for (int i = 0; i < tamanhoVetor; i++) {
            if (vetorFormas[i] instanceof FormaTridimensional) {
                FormaTridimensional formaTridimensional = (FormaTridimensional) vetorFormas[i];
                System.out.println("ID: " + formaTridimensional.getID() + ", Volume: " + formaTridimensional.obterVolume());
            }
        }
    }

    public static void verificarIntersecaoEsferasCirculos(Forma[] vetorFormas, int tamanhoVetor) {
        for (int i = 0; i < tamanhoVetor; i++) {
            for (int j = i + 1; j < tamanhoVetor; j++) {
                if ((vetorFormas[i] instanceof Circulo || vetorFormas[i] instanceof Esfera)
                        && (vetorFormas[j] instanceof Circulo || vetorFormas[j] instanceof Esfera)) {
                    if (vetorFormas[i].intercepta(vetorFormas[j])) {
                        System.out.println("As formas " + vetorFormas[i].getID() + " e " + vetorFormas[j].getID() + " se interceptam.");
                    } else {
                        System.out.println("As formas " + vetorFormas[i].getID() + " e " + vetorFormas[j].getID() + " não se interceptam.");
                    }
                }
            }
        }
    }
}
