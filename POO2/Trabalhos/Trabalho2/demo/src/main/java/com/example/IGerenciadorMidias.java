package com.example;

import java.util.List;

public interface IGerenciadorMidias {
   public void inserirMidia(Midia midia);
    public String consultarProduto(int codigo);
    public boolean verificarProdutoAlugado(int codigo);
    public int contarProdutosPorTitulo(String titulo);
    public Locacao alugarMidia(int codigoMidia, String cpfCliente, double valor, int tempLocacao, List<Cliente> clientes);
}
