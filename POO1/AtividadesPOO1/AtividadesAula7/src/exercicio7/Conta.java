package exercicio7;

public class Conta {
    private String nome;
    private double saldo;
    private int numero;

    public Conta(String nome, double saldo, int numero) {
        this.nome = nome;
        this.saldo = saldo;
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

}
