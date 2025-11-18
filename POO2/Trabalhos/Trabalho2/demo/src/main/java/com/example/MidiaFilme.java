package com.example;

public class MidiaFilme extends Midia{
    private int codigo;

    public MidiaFilme(String titulo, int tempFita, String[] genero, String tipo, int setor, boolean alugado,int codigo) {
        super(titulo, tempFita, genero, tipo, setor,alugado);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

}
