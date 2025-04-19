package Prática5;

import java.util.Scanner;

public class ThreadCalc extends Thread {
    private Calculadora<Integer> calculadora;

    public ThreadCalc(Calculadora<Integer> calculadora) {
        this.calculadora = calculadora;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Potência");
            System.out.println("6. Raiz Quadrática");
            System.out.println("7. Raiz Cúbica");
            System.out.println("8. Fatorial");
            System.out.println("9. Fibonacci");
            System.out.println("10. Progressão Aritmética");
            System.out.println("11. Progressão Geométrica");
            System.out.println("0. Sair");
            System.out.print("\nQual deseja:");

            int escolha = scanner.nextInt();

            if (escolha == 0) {
                break;
            }

            realizarOperacao(escolha);
        }
    }

    private void realizarOperacao(int escolha) {
        Scanner scanner = new Scanner(System.in);

        switch (escolha) {
            case 1:
                System.out.println("Digite o primeiro número:");
                int a = scanner.nextInt();
                System.out.println("Digite o segundo número:");
                int b = scanner.nextInt();
                int resultadoSoma = calculadora.soma(a, b);
                System.out.println("\nResultado: " + resultadoSoma);
                calculadora.setUltimoResultado(resultadoSoma);
                break;
            case 2:
                System.out.println("Digite o primeiro número:");
                int subtrahend = scanner.nextInt();
                System.out.println("Digite o segundo número:");
                int minuend = scanner.nextInt();
                int resultadoSubtracao = calculadora.subtracao(subtrahend, minuend);
                System.out.println("\nResultado: " + resultadoSubtracao);
                calculadora.setUltimoResultado(resultadoSubtracao);
                break;
            case 3:
                System.out.println("Digite o primeiro número:");
                int multiplicando = scanner.nextInt();
                System.out.println("Digite o segundo número:");
                int multiplicador = scanner.nextInt();
                int resultadoMultiplicacao = calculadora.multiplicacao(multiplicando, multiplicador);
                System.out.println("\nResultado: " + resultadoMultiplicacao);
                calculadora.setUltimoResultado(resultadoMultiplicacao);
                break;
            case 4:
                System.out.println("Digite o numerador:");
                int numerador = scanner.nextInt();
                System.out.println("Digite o denominador (diferente de zero):");
                int denominador = scanner.nextInt();
                Integer resultadoDivisao = calculadora.divisao(numerador, denominador);
                if (resultadoDivisao != null) {
                    System.out.println("\nResultado: " + resultadoDivisao);
                    calculadora.setUltimoResultado(resultadoDivisao);
                }
                break;
            case 5:
                System.out.println("Digite a base:");
                int base = scanner.nextInt();
                System.out.println("Digite o expoente:");
                int expoente = scanner.nextInt();
                int resultadoPotencia = calculadora.potencia(base, expoente);
                System.out.println("\nResultado: " + resultadoPotencia);
                calculadora.setUltimoResultado(resultadoPotencia);
                break;
            case 6:
                System.out.println("Digite o número para calcular a raiz quadrática:");
                int numeroRaizQuadratica = scanner.nextInt();
                Integer resultadoRaizQuadratica = calculadora.raizQuadratica(numeroRaizQuadratica);
                if (resultadoRaizQuadratica != null) {
                    System.out.println("\nResultado: " + resultadoRaizQuadratica);
                    calculadora.setUltimoResultado(resultadoRaizQuadratica);
                }
                break;
            case 7:
                System.out.println("Digite o número para calcular a raiz cúbica:");
                int numeroRaizCubica = scanner.nextInt();
                int resultadoRaizCubica = calculadora.raizCubica(numeroRaizCubica);
                System.out.println("\nResultado: " + resultadoRaizCubica);
                calculadora.setUltimoResultado(resultadoRaizCubica);
                break;
            case 8:
                System.out.println("Digite o número para calcular o fatorial:");
                int numeroFatorial = scanner.nextInt();
                Integer resultadoFatorial = calculadora.fatorial(numeroFatorial);
                if (resultadoFatorial != null) {
                    System.out.println("\nResultado: " + resultadoFatorial);
                    calculadora.setUltimoResultado(resultadoFatorial);
                }
                break;
            case 9:
                System.out.println("Digite o valor de n para calcular o termo n da sequência de Fibonacci:");
                int nFibonacci = scanner.nextInt();
                Integer resultadoFibonacci = calculadora.fibonacci(nFibonacci);
                if (resultadoFibonacci != null) {
                    System.out.println("\nResultado: " + resultadoFibonacci);
                    calculadora.setUltimoResultado(resultadoFibonacci);
                }
                break;
            case 10:
                System.out.println("Digite o primeiro termo (a1):");
                int a1ProgressaoAritmetica = scanner.nextInt();
                System.out.println("Digite a razão (r):");
                int rProgressaoAritmetica = scanner.nextInt();
                System.out.println("Digite o número de termos (n):");
                int nProgressaoAritmetica = scanner.nextInt();
                int resultadoProgressaoAritmetica = calculadora.progressaoAritmetica(a1ProgressaoAritmetica,
                        rProgressaoAritmetica, nProgressaoAritmetica);
                System.out.println("\nResultado: " + resultadoProgressaoAritmetica);
                calculadora.setUltimoResultado(resultadoProgressaoAritmetica);
                break;
            case 11:
                System.out.println("Digite o primeiro termo (a1):");
                int a1ProgressaoGeometrica = scanner.nextInt();
                System.out.println("Digite a razão (r):");
                int rProgressaoGeometrica = scanner.nextInt();
                System.out.println("Digite o número de termos (n):");
                int nProgressaoGeometrica = scanner.nextInt();
                int resultadoProgressaoGeometrica = calculadora.progressaoGeometrica(a1ProgressaoGeometrica,
                        rProgressaoGeometrica, nProgressaoGeometrica);
                System.out.println("\nResultado: " + resultadoProgressaoGeometrica);
                calculadora.setUltimoResultado(resultadoProgressaoGeometrica);
                break;
            default:
                System.out.println("Escolha inválida. Tente novamente.");
        }
    }
}
