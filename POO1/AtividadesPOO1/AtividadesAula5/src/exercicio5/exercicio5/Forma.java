package exercicio5;

public class Forma {
    protected String id;
    protected String cor;

    public Forma(String id, String cor) {
        this.id = id;
        this.cor = cor;
    }

    public String getID() {
        return id;
    }

    public String getCor() {
        return cor;
    }

    public boolean intercepta(Forma forma) {
        return false;
    }
}