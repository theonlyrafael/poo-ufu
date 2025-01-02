package exercicio4;

import java.util.Random;

public class Vendedores extends Funcionarios {
    private float comissão;
    private int totalVendas;

    public Vendedores (String nome, String RG, float salário) {
        super(nome, RG, salário);
        comissão = 0.05f;
        totalVendas = 0;
        Random r = new Random();
        totalVendas = r.nextInt();
    }

    public int getTotalVendas() {
        return totalVendas;
    }

    public float calculaSalario() {
        int total = totalVendas;
        totalVendas = 0;
        return getSalario() + total*comissão;
    }
}
