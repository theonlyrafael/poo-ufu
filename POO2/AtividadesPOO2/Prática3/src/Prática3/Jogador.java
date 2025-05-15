package Prática3;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Jogador extends Thread {
    private final String nome;
    private int toquesConsecutivos = 0;
    private int toquesAlternados = 0;
    private final Jogo jogo;

    public Jogador(String nome, Jogo jogo) {
        this.nome = nome;
        this.jogo = jogo;
    }

    @Override
    public void run() {
        while (!jogo.isFimDeJogo()) {
            jogar();
        }
    }

    private void jogar() {
        try {
            TimeUnit.SECONDS.sleep(1);
            jogo.toque(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public void incrementarToquesConsecutivos() {
        toquesConsecutivos++;
    }

    public void zerarToquesConsecutivos() {
        toquesConsecutivos = 0;
    }

    public void incrementarToquesAlternados() {
        toquesAlternados++;
    }

    public void zerarToquesAlternados() {
        toquesAlternados = 0;
    }

    public int getToquesConsecutivos() {
        return toquesConsecutivos;
    }

    public int getToquesAlternados() {
        return toquesAlternados;
    }
}
