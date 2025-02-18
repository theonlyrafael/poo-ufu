package Humanos;

import java.util.ArrayList;
import java.util.List;

public class Mae extends Mulher {

    protected String[] filhos;
    protected boolean trabalha;
    protected List<String> listaTarefas;
    protected List<Float> contas;

    public Mae(String nome, String tipoOlhos, String cor, float altura, int idade,
               String[] filhos, boolean trabalha) {
        super(nome, tipoOlhos, cor, altura, idade);

        this.filhos = filhos;
        this.trabalha = trabalha;
        this.listaTarefas = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public void imprimir(List<?> lista) {
        for (Object item : lista) {
            System.out.println(item);
        }
    }

    public void imprimir(List<?> lista, String titulo) {
        System.out.println(titulo);
        imprimir(lista);
    }

    public void addTarefa(String tarefa) {
        listaTarefas.add(tarefa);
    }

    public void addContas(float conta) {
        contas.add(conta);
    }

    public String[] getFilhos() {
        return filhos;
    }

    public boolean isTrabalha() {
        return trabalha;
    }

    public List<String> getListaTarefas() {
        return listaTarefas;
    }

    public List<Float> getContas() {
        return contas;
    }
}
