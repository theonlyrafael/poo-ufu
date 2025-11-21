import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import com.example.Cliente;
import com.example.Locacao;
import com.example.MidiaFilme;

public class LocacaoTeste {

    @Test
    public void testeDataDevolucao(){
        MidiaFilme filme = new MidiaFilme("Titulo", 118, new String[] { "Comedia", "Aventura"}, "DVD", 1, true, 154);
        Cliente cliente = new Cliente("Carlos", "123456789", new String[] { "Rua A" , "bairro B", "123", "etc"});

        Locacao locacao = new Locacao(filme, cliente, 10.0, 5, LocalDate.of(2021, 10, 10));

        LocalDate resultEsperado = LocalDate.of(2021, 10, 15);
        LocalDate resultObtido = locacao.getDataDevolucao();

        assertEquals(resultEsperado, resultObtido);
    }
    
}
