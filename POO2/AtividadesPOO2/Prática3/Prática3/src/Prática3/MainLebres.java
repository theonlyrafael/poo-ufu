package Prática3;

public class MainLebres {
    public static void main(String a[]) {
        Lebres[] lebres = new Lebres[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            lebres[i] = new Lebres("Lebres " + (i + 1));
            threads[i] = new Thread(lebres[i]);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int distanciaMaxima = -1;
        Lebres lebreVencedora = null;

        for (Lebres lebre : lebres) {
            if (lebre.getDistanciaPercorrida() > distanciaMaxima) {
                distanciaMaxima = lebre.getDistanciaPercorrida();
                lebreVencedora = lebre;
            }
        }

        System.out.println("\nLebre vencedora: " + lebreVencedora.getNome());
        for (Lebres lebre : lebres) {
            System.out.println(lebre.getNome() + " terminou em " + lebre.getDistanciaPercorrida() + " metros com " +
                    lebre.getTotalPulos() + " pulos.");
        }
    }
}
