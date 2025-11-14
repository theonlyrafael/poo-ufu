package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeMidias implements IGerenciadorMidias{
   private List<Midia> midias;

    public GerenciadorDeMidias( ArrayList<Midia> midias) {
        this.midias = midias;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    @Override
    public void inserirMidia(Midia midia) {
        midias.add(midia);
    }

    @Override
    public String consultarProduto(int codigo) {
        for (int i = 0; i < midias.size(); i++) {
            if (midias.get(i) instanceof MidiaFilme) {
                if (((MidiaFilme) midias.get(i)).getCodigo() == codigo) {
                    return midias.get(i).getTitulo();
                }
            } else if (midias.get(i) instanceof MidiaSerie) {
                if (((MidiaSerie) midias.get(i)).getCodigos().contains(codigo)) {
                    return midias.get(i).getTitulo();
                }
            }
        }
        return "Produto não encontrado";
    }

    @Override
    public boolean verificarProdutoAlugado(int codigo) {
        for (Midia midia : midias) {
            if (midia instanceof MidiaFilme) {
                if (((MidiaFilme) midia).getCodigo() == codigo) {
                    return midia.getAlugado();
                }
            } else if (midia instanceof MidiaSerie) {
                List<Integer> codigos = ((MidiaSerie) midia).getCodigos();
                if (codigos.contains(codigo)) {
                    return midia.getAlugado();
                }
            }
        }
        return false;
    }

    @Override
    public int contarProdutosPorTitulo(String titulo) {
        int count = 0;
        for (Midia midia : midias) {
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Locacao alugarMidia(int codigoMidia, String cpfCliente, double valor, int tempLocacao, List<Cliente> clientes) {
        Midia midiaParaAlugar = null;
        for (Midia midia : midias) {
            if (midia instanceof MidiaFilme) {
                MidiaFilme filme = (MidiaFilme) midia;
                if (filme.getCodigo() == codigoMidia && !filme.getAlugado()) {
                    midiaParaAlugar = filme;
                    break;
                }
            } else if (midia instanceof MidiaSerie) {
                MidiaSerie serie = (MidiaSerie) midia;
                if (serie.getCodigos().contains(codigoMidia) && !serie.getAlugado()) {
                    midiaParaAlugar = serie;
                    break;
                }
            }
        }

        if (midiaParaAlugar == null) {
            return null;
        }

        Cliente clienteAlugando = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                clienteAlugando = cliente;
                break;
            }
        }

        if (clienteAlugando == null) {
            return null;
        }

        midiaParaAlugar.setAlugado(true);

        Locacao locacao = new Locacao(midiaParaAlugar, clienteAlugando, valor, tempLocacao, LocalDate.now());
        

        return locacao;
    }

}
