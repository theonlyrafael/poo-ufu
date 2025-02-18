package Humanos;

public class Homem extends Pessoa {

    protected char sexo;

    public Homem(String nome, String tipoOlhos, String cor, float altura, int idade) {
        
        super(nome, tipoOlhos, cor, altura, idade);

        this.sexo = 'M';
    }

    public char getSexo() {
        return sexo;
    }
}
