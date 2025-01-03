package exercicio5;

public class Funcionario {
    protected int matricula, idade;
    protected String nome, CPF;
    protected float salario;

    public Funcionario(int m, int i, String n, String cpf, float salario) {
        this.matricula = m;
        this.idade = i;
        this.nome = n;
        this.CPF = cpf;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public float getSalario() {
        return salario;
    }
}
