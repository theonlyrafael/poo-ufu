package exercicio3;

import java.util.Random;

public class NaveEspacial {
    private String nome;
    private int velocidade;
    Random aleatorio = new Random();

    public NaveEspacial(String s) {
        nome = s;
        velocidade = aleatorio.nextInt(6) + 5;
    }

    public String getNome() {
        return nome;
    }

    public int getVel() {
        return velocidade;
    }

    public String mostrarNave() {
        return "\r\nNome da nave: " + nome + "\r\nVelocidade: " + velocidade;
    }

    public void pararNave() {
        velocidade = 0;
    }

    public void ligarNave(int v) {
        velocidade = v;
    }

    public String naveMaisRapida(NaveEspacial n) {
        if (n.getVel() > velocidade) {
            return "Nave " + n.getNome() + " é mais rapida que a nave " + nome;
        } else if (n.getVel() < velocidade) {
            return "Nave " + nome + " é mais rápida que a nave " + n.getNome();
        } else {
            return "As naves possuem a mesma velocidade.";
        }
    }
}
