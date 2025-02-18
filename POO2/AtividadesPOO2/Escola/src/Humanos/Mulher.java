package Humanos;

public class Mulher extends Pessoa {

    protected char sexo;

    public Mulher(String nome, String tipoOlhos, String cor, float altura, int idade) {
        
        super(nome, tipoOlhos, cor, altura, idade);

        this.sexo = 'F';
    }

    public char getSexo() {
        return sexo;
    }
}
