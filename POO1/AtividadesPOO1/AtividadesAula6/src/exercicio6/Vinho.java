package exercicio6;

public abstract class Vinho implements Produto {
    private static int idVinhos = 1;
    private int anoProdução;
    private int idLocal;

    public Vinho(int anoProdução) {
        this.anoProdução = anoProdução;
        this.idLocal = idVinhos;
        idVinhos++;
    }

    @Override
    public String getID() {
        return anoProdução + "-" + idLocal;
    }
}
