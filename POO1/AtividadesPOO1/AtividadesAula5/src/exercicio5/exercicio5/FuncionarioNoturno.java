package exercicio5;

import java.util.Random;

public class FuncionarioNoturno extends Funcionario {
    protected int noitesTrabalhadas;
    private float salarioBaseNoturno;

    public FuncionarioNoturno(int matricula, int idade, String nome, String CPF, int noitesTrabalhadas) {
        super(matricula, idade, nome, CPF, 0); 
        this.noitesTrabalhadas = noitesTrabalhadas;
        this.salarioBaseNoturno = gerarSalarioBaseNoturnoAleatorio();
    }

    private float gerarSalarioBaseNoturnoAleatorio() {
        Random random = new Random();
        float valorMinimo = 500.0f;
        float valorMaximo = 1000.0f;
        return valorMinimo + (valorMaximo - valorMinimo) * random.nextFloat();
    }

    public int getNoitesTrabalhadas() {
        return noitesTrabalhadas;
    }

    public void atualizarNoitesTrabalhadas(int novasNoitesTrabalhadas) {
        this.noitesTrabalhadas = novasNoitesTrabalhadas;
    }

    @Override
    public float getSalario() {
        return super.getSalario() + (noitesTrabalhadas * this.salarioBaseNoturno);
    }
}

