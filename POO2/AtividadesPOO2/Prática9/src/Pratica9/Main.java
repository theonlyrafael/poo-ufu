package Pratica9;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas();

        lista.adicionarTarefa(new Tarefa("Lavar o carro"));
        lista.adicionarTarefa(new Tarefa("Fazer compras"));
        lista.adicionarTarefa(new Tarefa("Estudar Java"));

        System.out.println("Lista de Tarefas:");
        for (Tarefa tarefa : lista) {
            System.out.println("- " + tarefa.getDescricao());
        }
    }
}
