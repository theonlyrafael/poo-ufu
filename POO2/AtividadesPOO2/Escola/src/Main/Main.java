package Main;

import Humanos.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Criando um colégio que aceita apenas alunas femininas
        Colegio colegio = new Colegio();

        // Adicionando alunas
        List<Filha> alunas = new ArrayList<>();
        alunas.add(new Filha("Taina", "Azuis", "Branca", 1.65f, 14, new String[0], false, true));
        alunas.add(new Filha("Janaina", "Castanhos", "Parda", 1.75f, 15, new String[0], false, true));
        alunas.add(new Filha("Talita", "Verdes", "Branca", 1.50f, 15, new String[0], false, true));
        alunas.add(new Filha("Ana", "Castanhos", "Branca", 1.81f, 14, new String[0], false, true));
        alunas.add(new Filha("Maria", "Castanhos", "Parda", 1.72f, 15, new String[0], false, true));
        alunas.add(new Filha("Fernanda", "Castanhos", "Branca", 1.74f, 14, new String[0], false, true));
        alunas.add(new Filha("Leila", "Verdes", "Afro descendente", 1.70f, 14, new String[0], false, true));

        // Adicionando classes
        colegio.adicionarElemento(colegio.getClasse(), 1, 101);
        colegio.adicionarElemento(colegio.getClasse(), 1, 102);

        // Associando alunas às classes
        for (Filha aluna : alunas) {
            int andar = 1; // todas as alunas estão no primeiro andar
            int sala = 101; // sala padrão para todas as alunas
            String chave = andar + "," + sala;
            colegio.adicionarElemento(colegio.getAlunos(), chave, aluna.getNome());
        }

        // Imprimindo informações
        System.out.println("Alunas com suas classes e salas:");
        colegio.imprimirElementos(colegio.getAlunos());
    }
}

