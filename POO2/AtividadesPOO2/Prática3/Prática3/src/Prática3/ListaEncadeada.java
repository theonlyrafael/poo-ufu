package Prática3;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionar(int valor) {
        No novoNo = new No(valor);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public void imprimir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}
