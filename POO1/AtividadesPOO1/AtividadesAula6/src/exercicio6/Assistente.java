package exercicio6;

public class Assistente extends Funcionário {
    public Assistente(String n, String m, double sbase) {
        super(n, m, sbase);
    }

    @Override
    public double calculaSalario() {
        return getSalariBase();
    }
}
