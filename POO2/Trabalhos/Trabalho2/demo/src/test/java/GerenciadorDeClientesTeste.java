import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.example.Cliente;
import com.example.GerenciadorDeClientes;

public class GerenciadorDeClientesTeste {
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    GerenciadorDeClientes gc = new GerenciadorDeClientes(clientes);

    @Test
    public void testInserirCliente() {
        String[] endereco = { "Rua", "Bairro", "Cidade", "Estado" };
        Cliente cliente = new Cliente("Carlos", "12345678901", endereco);
        gc.inserirCliente(cliente);

        assertTrue(gc.getClientes().contains(cliente));
    }

    @Test
    public void testConsultarCliente() {
        Cliente cliente = new Cliente("Sergio Ribeiro", "12345678901", new String[] { "Rua A", "Bairro B", "123", "etc" });
        clientes.add(cliente);

        String cpf = "12345678901";

        String resultEsperado = "Sergio Ribeiro";
        String resultObtido = gc.consultarCliente(cpf);

        assertEquals(resultEsperado, resultObtido);
    }
}
