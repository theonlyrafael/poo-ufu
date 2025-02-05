package Provas;

public class Mouse extends Produto {
    private String tipo;

    public Mouse(String tipo) {
        super(20.0, "MOUSE");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
}
