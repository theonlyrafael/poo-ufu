package com.example;

import java.util.List;

public class MidiaSerie extends Midia {
    private List<Integer> codigos;

    public MidiaSerie(String titulo, int tempFita, String[] genero, String tipo, int setor, boolean alugado,
            List<Integer> codigos) {
        super(titulo, tempFita, genero, tipo, setor, alugado);
        this.codigos = codigos;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }
}
