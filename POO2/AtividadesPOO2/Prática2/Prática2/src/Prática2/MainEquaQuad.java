package Prática2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainEquaQuad{
    public static void main(String[] args) {
        List<EquacaoQuadratica> equacoes = new ArrayList<>();
        equacoes.add(new EquacaoQuadratica(-1, 4, -3));          // f(x) = -x^2 + 4x - 3
        equacoes.add(new EquacaoQuadratica(-1, 50, 15000));     // f(x) = -x^2 + 50x + 15000
        equacoes.add(new EquacaoQuadratica(6, -4, 5));          // f(x) = 6x^2 - 4x + 5
        equacoes.add(new EquacaoQuadratica(1, 0, -9));          // f(x) = x^2 - 9
        equacoes.add(new EquacaoQuadratica(3, 3, 0));           // f(x) = 3x^2 + 3x
        equacoes.add(new EquacaoQuadratica(2, 3, 5));           // f(x) = 2x^2 + 3x + 5
        equacoes.add(new EquacaoQuadratica(-1, 2, -4));         // f(x) = -x^2 + 2x - 4
        equacoes.add(new EquacaoQuadratica(1, -5, 6));          // f(x) = x^2 - 5x + 6
        equacoes.add(new EquacaoQuadratica(1, -4, 3));          // f(x) = x^2 - 4x + 3
        equacoes.add(new EquacaoQuadratica(-1, 2, 4));          // f(x) = -x^2 + 2x + 4
        equacoes.add(new EquacaoQuadratica(-3, 0, 0));          // f(x) = -3x^2
        equacoes.add(new EquacaoQuadratica(0, 4, -10));         // f(x) = 4x - 10

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (EquacaoQuadratica equacao : equacoes) {
            executorService.execute(() -> {
                double[] raizes = EquacaoQuadratica.calcularRaizes(equacao.a, equacao.b, equacao.c);
                System.out.println("Equação:" + equacao.a + "x^2" + " + " + equacao.b + "x + " + equacao.c);
                if (raizes.length == 0) {
                    System.out.println("Não há raízes reais.");
                } else if (raizes.length == 1) {
                    System.out.println("Raízes: " + raizes[0]);
                } else {
                    System.out.println("Raízes: " + raizes[0] + ", " + raizes[1]);
                }
                System.out.println("-----------");
            });
        }

        executorService.shutdown();
    }
}

