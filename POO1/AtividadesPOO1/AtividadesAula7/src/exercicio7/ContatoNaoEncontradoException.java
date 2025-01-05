package exercicio7;

public class ContatoNaoEncontradoException extends Exception {
    public ContatoNaoEncontradoException() {
        super("Contato nao encontrado!");
    }

    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
