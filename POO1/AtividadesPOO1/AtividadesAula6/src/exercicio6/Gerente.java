package exercicio6;

public class Gerente extends Funcionário {
    public Gerente(String n, String m, double sbase) {
        super(n, m, sbase);
    }

    @Override
    public double calculaSalario() {
        return getSalariBase()*2;
    }
}
