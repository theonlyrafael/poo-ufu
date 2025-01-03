package exercicio5;

public class FuncionarioComissionado extends Funcionario {
    protected float comissao;

    public FuncionarioComissionado(int matricula, int idade, String nome, String CPF, float salario, float comissao) {
        super(matricula, idade, nome, CPF, salario);
        this.comissao = comissao;
    }

    public float getComissao() {
        return comissao;
    }

    public void atualizarComissao(float novaComissao) {
        this.comissao = novaComissao;
    }

    @Override
    public float getSalario() {
        return super.getSalario() + comissao;
    }
}
