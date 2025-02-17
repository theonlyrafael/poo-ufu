package Humanos;

import java.util.ArrayList;
import java.util.List;

public class Filha extends Mãe {

    protected boolean estudante;
    protected List<String> aulas;

    public Filha(String nome, String tipoOlhos, String cor, float altura, int idade,
                 String[] filhos, boolean trabalha, boolean estudante) {
        super(nome, tipoOlhos, cor, altura, idade, filhos, trabalha);

        this.estudante = estudante;
        this.aulas = new ArrayList<>();
    }

    public void imprimirHorariosDeAula() {
        System.out.println("Horários de Aula:");
        imprimir(aulas);
    }

    public void addAula(String aula) {
        aulas.add(aula);
    }

    public boolean isEstudante() {
        return estudante;
    }

    public List<String> getAulas() {
        return aulas;
    }
}
