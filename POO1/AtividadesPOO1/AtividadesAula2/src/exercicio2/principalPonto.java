package exercicio2;

import java.util.*;

public class principalPonto {
    public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ponto 1:\r\nDigite a coordenada do ponto X:");
            double x1 = sc.nextDouble();
            System.out.println("Digite a coordenada do ponto Y: ");
            double y1 = sc.nextDouble();
           
            Ponto p1 = new Ponto(x1, y1);
            p1.iniciarCoordenadas(x1, y1);
            System.out.println(p1.retPonto());

            System.out.println("\r\nPonto 2:\r\nDigite a coordenada do ponto X:");
            double x2 = sc.nextDouble();
            System.out.println("Digite a coordenada do ponto Y: ");
            double y2 = sc.nextDouble();
            
            Ponto p2 = new Ponto(x2, y2);
            p2.iniciarCoordenadas(x2, y2);
            System.out.println(p2.retPonto());

            double distancia = p1.calculaDistancia(p2);

            System.out.println("Distancia entre os pontos: " + distancia);

        }
}
