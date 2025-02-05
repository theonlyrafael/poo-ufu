package exercicio4;

public class Funcionarios {
    private String nome;
    private String RG;
    private float salário;

    public Funcionarios (String nome, String RG, float salário) {
        this.nome = nome;
        this.RG = RG;
        this.salário = salário;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salário;
    }

    public float calculaSalario() {
        return getSalario();
    }

    /*public void setSalario(float salário) {
        this.salário = salário;
    }*/
}