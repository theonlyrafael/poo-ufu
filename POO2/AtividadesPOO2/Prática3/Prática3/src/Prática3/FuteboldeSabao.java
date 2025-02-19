package Prática3;

public class FuteboldeSabao {
    public static void main(String[] args) {
        int numeroJogadores = obterNumeroJogadores();

        if (numeroJogadores % 2 == 1 || numeroJogadores < 4) {
            System.out.println("O número de jogadores deve ser par e maior que 4.");
            return;
        }

        Jogo jogo = new Jogo(numeroJogadores);
        jogo.iniciarJogo();
    }

    private static int obterNumeroJogadores() {

        return 6;
    }
}