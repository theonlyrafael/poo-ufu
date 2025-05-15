package Prática3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Jogo {
    private final int numeroJogadores;
    private final Jogador[] jogadores;
    private int tempoJogo;
    private boolean fimDeJogo;

    public Jogo(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
        this.jogadores = new Jogador[numeroJogadores];
        this.tempoJogo = 0;
        this.fimDeJogo = false;

        for (int i = 0; i < numeroJogadores; i++) {
            jogadores[i] = new Jogador("Jogador " + (i + 1), this);
        }
    }

    public void iniciarJogo() {
        for (Jogador jogador : jogadores) {
            jogador.start();
        }

        try {
            TimeUnit.MINUTES.sleep(5); // Jogo dura 5 minutos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fimDeJogo = true;

        for (Jogador jogador : jogadores) {
            try {
                jogador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        imprimirPlacar();
    }

    public synchronized void toque(Jogador jogador) {
        if (fimDeJogo) {
            return;
        }

        Random random = new Random();
        int jogadorAlvoIndex = random.nextInt(numeroJogadores);

        Jogador jogadorAlvo = jogadores[jogadorAlvoIndex];

        if (jogador == jogadorAlvo) {
            return;
        }

        jogador.incrementarToquesConsecutivos();
        jogadorAlvo.incrementarToquesConsecutivos();

        if (jogador.getToquesConsecutivos() == 5) {
            marcarGol(jogador);
            jogador.zerarToquesConsecutivos();
            jogadorAlvo.zerarToquesConsecutivos();
        } else {
            jogador.incrementarToquesAlternados();
            jogadorAlvo.incrementarToquesAlternados();

            if (jogador.getToquesAlternados() == 3) {
                marcarGol(jogador);
                jogador.zerarToquesAlternados();
                jogadorAlvo.zerarToquesAlternados();
            }
        }
    }

    private void marcarGol(Jogador jogador) {
        System.out.println("Gol para " + jogador.getNome() + ": " +
                (jogador.getToquesConsecutivos() == 5 ? "5 toques" : "Tabelinha"));
    }

    public synchronized boolean isFimDeJogo() {
        return fimDeJogo;
    }

    private void imprimirPlacar() {
        System.out.println("\nPlacar Final:");

        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getToquesConsecutivos() +
                    " toques consecutivos, " + jogador.getToquesAlternados() + " tabelinhas");
        }
    }
}
