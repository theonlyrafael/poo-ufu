package com.example;

public class Cliente {
    private String nome, cpf;
    private String[] endereco;

    public Cliente(String nome, String cpf, String[] endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String[] getEndereco() {
        return endereco;
    }

}
