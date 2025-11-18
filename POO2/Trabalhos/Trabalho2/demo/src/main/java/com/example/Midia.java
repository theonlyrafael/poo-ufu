package com.example;

public abstract class Midia {
    private String titulo;
    private int tempFita; // minutos
    private String[] genero;
    private String tipo;
    private int setor;
    private boolean alugado;

    public Midia(String titulo, int tempFita, String[] genero, String tipo, int setor, boolean alugado) {
        this.titulo = titulo;
        this.tempFita = tempFita;
        this.genero = genero;
        this.tipo = tipo;
        this.setor = setor;
        this.alugado = alugado;
    }

    public String getTitulo() {
        return titulo;
    }


    public int getTempFita() {
        return tempFita;
    }

    public String[] getGenero() {
        return genero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getSetor() {
        return setor;
    }

    public boolean getAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }
}
