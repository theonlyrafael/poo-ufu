package com.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeLocacoes implements IGerenciadorLocacoes{
    private List<Locacao> locacoes;

    public GerenciadorDeLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    @Override
    public LocalDate verificarDataDisponibilidade(int codigoProdutoAlugado, ArrayList<Midia> midias) {
        for (Locacao locacao : locacoes) {
            Midia midia = locacao.getMidias();
            if (midia instanceof MidiaFilme && ((MidiaFilme) midia).getCodigo() == codigoProdutoAlugado) {
                return locacao.getDataDevolucao();
            } else if (midia instanceof MidiaSerie && ((MidiaSerie) midia).getCodigos().contains(codigoProdutoAlugado)) {
                return locacao.getDataDevolucao();
            }
        }
        return null;
    }

    @Override
    public String devolverMidia(int codigoMidia) {
        for (Locacao locacao : locacoes) {
            Midia midia = locacao.getMidias();
            if (midia instanceof MidiaFilme) {
                MidiaFilme filme = (MidiaFilme) midia;
                if (filme.getCodigo() == codigoMidia && filme.getAlugado()) {
                    filme.setAlugado(false);
                    LocalDate dataDevolucao = locacao.getDataDevolucao();
                    if (!LocalDate.now().isAfter(dataDevolucao)) {
                        return "Mídia devolvida com sucesso.";
                    } else {
                        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, LocalDate.now());
                        double multa = diasAtraso * 2;
                        return "Mídia devolvida, mas com multa de " + multa;
                    }
                }
            } else if (midia instanceof MidiaSerie) {
                MidiaSerie serie = (MidiaSerie) midia;
                if (serie.getCodigos().contains(codigoMidia) && serie.getAlugado()) {
                    serie.setAlugado(false);
                    LocalDate dataDevolucao = locacao.getDataDevolucao();
                    if (!LocalDate.now().isAfter(dataDevolucao)) {
                        return "Mídia devolvida com sucesso.";
                    } else {
                        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, LocalDate.now());
                        double multa = diasAtraso * 2;
                        return "Mídia devolvida, mas com multa de " + multa;
                    }
                }
            }
        }
        return "Mídia não encontrada.";
    }
}
