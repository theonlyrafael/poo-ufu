package exercicio6;

public abstract class Funcionário {
    private String nome, matricula;
    private double salario_base;

    public Funcionário(String n, String m, double sbase) {
        this.nome = n;
        this.matricula = m;
        this.salario_base = sbase;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalariBase() {
        return salario_base;
    }

    public abstract double calculaSalario();
}