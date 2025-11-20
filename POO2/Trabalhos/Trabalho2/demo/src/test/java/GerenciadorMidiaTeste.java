import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.Cliente;
import com.example.GerenciadorDeMidias;
import com.example.Locacao;
import com.example.Midia;
import com.example.MidiaFilme;

public class GerenciadorMidiaTeste {
    private ArrayList<Midia> midias = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    private GerenciadorDeMidias gm = new GerenciadorDeMidias(midias);

    @Test
    public void testInserirMidia() {
        String[] generos = { "Acao", "aventura" };
        MidiaFilme midia = new MidiaFilme("Titulo", 118, generos, "DVD", 5, false, 576);
        gm.inserirMidia(midia);

        assertTrue(gm.getMidias().contains(midia));
    }

    @Test
    public void testConsultarProduto() {
        MidiaFilme midia = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura" }, "DVD", 1, true, 001);
        midias.add(midia);

        int codigo = 001;

        String resultEsperado = "Titulo";
        String resultObtido = gm.consultarProduto(codigo);

        assertEquals(resultEsperado, resultObtido);
    }

    @Test
    public void testVerificarProdutoAlugado() {
        MidiaFilme midia = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura" }, "DVD", 1, true, 555);
        midias.add(midia);

        int codigo = 555;

        boolean resultEsperado = true;
        boolean resultObtido = gm.verificarProdutoAlugado(codigo);

        assertEquals(resultEsperado, resultObtido);
    }

    @Test
    public void testContarProdutosPorTitulo() {
        MidiaFilme midia = new MidiaFilme("De volta para o futuro", 118, new String[] { "Comedia", "Aventura" }, "DVD",
                1, true, 555);
        midias.add(midia);

        String titulo = "De volta para o futuro";

        int resultEsperado = 1;
        int resultObtido = gm.contarProdutosPorTitulo(titulo);

        assertEquals(resultEsperado, resultObtido);
    }

    @Test
    public void testAlugarMidia() {
        MidiaFilme midia = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura" }, "DVD", 1, false, 555);
        midias.add(midia);
        Cliente cliente = new Cliente("Sergio Ribeiro", "12345678901",
                new String[] { "Rua A", "Bairro B", "123", "etc" });
        clientes.add(cliente);

        int codigoMidia = 555;
        String cpfCliente = "12345678901";
        double valor = 10.0;
        int tempLocacao = 5;
        String resultEsperado = "", resultObtido = "";

        Locacao re = new Locacao(midia, cliente, valor, tempLocacao, LocalDate.now());
        if(re != null){
            resultEsperado = "Midia alugada com sucesso";
        }
        Locacao ro = gm.alugarMidia(codigoMidia, cpfCliente, valor, tempLocacao, clientes);
        if(ro != null){
            resultObtido = "Midia alugada com sucesso";
        }

        assertEquals(resultEsperado, resultObtido);
    }

}
