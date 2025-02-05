package Provas;

public class Livro extends Produto {
    private String título;

    public Livro(String título) {
        super(30.0, "LIVRO");
        this.título = título;
    }

    public String getTítulo() {
        return título;
    }
    
}
