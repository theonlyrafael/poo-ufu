package Pratica9;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ListaDeTarefas implements Iterable<Tarefa> {
    private List<Tarefa> tarefas;

    public ListaDeTarefas() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public Iterator<Tarefa> iterator() {
        return new TarefaIterator();
    }

    private class TarefaIterator implements Iterator<Tarefa> {
        private int indice = 0;

        @Override
        public boolean hasNext() {
            return indice < tarefas.size();
        }

        @Override
        public Tarefa next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("Não há mais tarefas disponíveis.");
            }
            return tarefas.get(indice++);
        }
    }
}
