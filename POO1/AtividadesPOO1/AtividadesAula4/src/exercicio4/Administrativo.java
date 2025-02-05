package exercicio4;

import java.util.Random;

public class Administrativo extends Funcionarios {
    private float valorHoraExtra;
    private int horaExtra;
    private int totalVendas;

    public Administrativo(String nome, String RG, float salário) {
        super(nome, RG, salário);
        valorHoraExtra = 0.01f;
        horaExtra = 0;
        totalVendas = 0;
        Random r = new Random();
        totalVendas = r.nextInt();

    }
    
    public int getHoraExtra() {
        return horaExtra;
    }

    public int getTotalVendas() {
        return totalVendas;
    }

    public void setHoraExtra(int horas) {
        horaExtra += horas;
    }

    public float calculaSalario() {
        int total = totalVendas;
        totalVendas = 0;
        return getSalario() + total*valorHoraExtra;
    }
}
