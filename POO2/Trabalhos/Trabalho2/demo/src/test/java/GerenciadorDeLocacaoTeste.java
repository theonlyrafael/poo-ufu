import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.Cliente;
import com.example.GerenciadorDeLocacoes;
import com.example.Locacao;
import com.example.Midia;
import com.example.MidiaFilme;


public class GerenciadorDeLocacaoTeste {
    private ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Midia> midias = new ArrayList<Midia>();
    GerenciadorDeLocacoes gl = new GerenciadorDeLocacoes(locacoes);

    @Test
    public void testVerificarDataDisponibilidade() {
        MidiaFilme midia = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura" }, "DVD", 1, true, 555);
        midias.add(midia);
        Cliente cliente = new Cliente("Sergio Ribeiro", "12345678901",
                new String[] { "Rua A", "Bairro B", "123", "etc" });
        clientes.add(cliente);
        Locacao locacao = new Locacao(midias.get(0), clientes.get(0), 10.0, 5, LocalDate.of(2024, 3, 25));
        locacoes.add(locacao);

        int codigo = 555;

        LocalDate resultEsperado = LocalDate.of(2024, 03, 30);
        LocalDate resultObtido = gl.verificarDataDisponibilidade(codigo, midias);

        assertEquals(resultEsperado, resultObtido);
    }

    @Test
    public void testeDevolverMidia() {
        MidiaFilme midia = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura" }, "DVD", 1, true, 555);
        midias.add(midia);
        Cliente cliente = new Cliente("Sergio Ribeiro", "12345678901",
                new String[] { "Rua A", "Bairro B", "123", "etc" });
        clientes.add(cliente);
        Locacao locacao = new Locacao(midias.get(0), clientes.get(0), 10.0, 5, LocalDate.of(2024, 3, 25));
        locacoes.add(locacao);

        int codigo = 555;

        String resultEsperado = "Mídia devolvida, mas com multa de 4.0";
        String resultObtido = gl.devolverMidia(codigo);

        assertEquals(resultEsperado, resultObtido);
    }

}
