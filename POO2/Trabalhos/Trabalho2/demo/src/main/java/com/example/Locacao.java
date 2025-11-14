package com.example;

import java.time.LocalDate;

public class Locacao {
    private Midia tituloMidia;
    private Cliente nomeCliente;
    private double valor;
    private int tempLocacao; // dias
    private LocalDate dataLocacao;

    public Locacao(Midia tituloMidia, Cliente nomeCliente, double valor, int tempLocacao, LocalDate dataLocacao) {
        this.tituloMidia = tituloMidia;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.tempLocacao = tempLocacao;
        this.dataLocacao = dataLocacao;
    }

    public Midia getMidias() {
        return tituloMidia;
    }

    public Cliente getCliente() {
        return nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public int getTempLocacao() {
        return tempLocacao;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataLocacao.plusDays(tempLocacao);
    }

}
