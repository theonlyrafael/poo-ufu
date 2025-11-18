package com.example;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IGerenciadorLocacoes {
  public LocalDate verificarDataDisponibilidade(int codigoProdutoAlugado, ArrayList<Midia> midias);
  public String devolverMidia(int codigoMidia);
}
