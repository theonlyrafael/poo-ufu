package altexercicio2;

import java.util.*;
import exercicio2.Ponto;

public class mainCirculo {
    public static void main(String[] args) {
        Circulo c = new Circulo();
        Ponto p = new Ponto();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do círculo: ");
        String nome = sc.nextLine();
        c.setNome(nome);

        System.out.print("Digite as coordenadas do centro: ");
        double cX = sc.nextDouble();
        double cY = sc.nextDouble();
        p.iniciarCoordenadas(cX, cY);
        c.setCentro(p);

        System.out.print("Digite o raio do círculo: ");
        int raio = sc.nextInt();
        c.setRaio(raio);
        c.iniciarCirculo(nome, p, raio);
        c.calculaDiametro();
        c.calculaArea();
        c.calculaPerimetro();
               
    }

}