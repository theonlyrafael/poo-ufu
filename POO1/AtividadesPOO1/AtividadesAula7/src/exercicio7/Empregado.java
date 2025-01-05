package exercicio7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Empregado implements Comparable {
    private String cpf;
    private int idade;
    private float salario;

    public Empregado(String cpf, int idade, float salario) {
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public float getSalario() {
        return salario;
    }

    public String getTextoArq() {
        return cpf + "###" + idade + "###" + salario;
    }

    public void salvarTexto(String caminho) {
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(new File(caminho + "\\" + cpf)));
            escritor.write(getTextoArq() + "\n");
            escritor.flush();
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Empregado(String linha) {
        String valores[] = linha.split("###");
        this.cpf = valores[0];
        this.idade = Integer.parseInt(valores[1]);
        this.salario = Float.parseFloat(valores[2]);
    }

    @Override
    public int compareTo(Object o) {
        if (this.idade > ((Empregado) o).getIdade()) {
            return 1;
        } else if (this.idade < ((Empregado) o).getIdade()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + "\n IDADE: " + idade + "\n SALARIO: " + salario;
    }
}
