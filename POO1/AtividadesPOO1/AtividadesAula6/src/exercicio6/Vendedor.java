package exercicio6;

public class Vendedor extends Funcionário {
    private double comissao;

    public Vendedor(String n, String m, double sbase, double c) {
        super(n, m, sbase);
        this.comissao = c;
    }

    @Override
    public double calculaSalario() {
        return getSalariBase()+comissao;
    }
}
