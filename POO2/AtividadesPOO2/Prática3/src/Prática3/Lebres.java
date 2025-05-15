package Prática3;

import java.util.Random;

public class Lebres implements Runnable {
    private String nome;
    private int distanciaPercorrida;
    private int totalPulos;

    public Lebres(String nome) {
        this.nome = nome;
        this.distanciaPercorrida = 0;
        this.totalPulos = 0;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (distanciaPercorrida < 20) {
            int salto = random.nextInt(3) + 1;
            distanciaPercorrida += salto;
            totalPulos++;
            System.out.println(
                    nome + " pulou " + salto + " metros. Distância percorrida: " + distanciaPercorrida + " metros.");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTotalPulos() {
        return totalPulos;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public String getNome() {
        return nome;
    }
}
