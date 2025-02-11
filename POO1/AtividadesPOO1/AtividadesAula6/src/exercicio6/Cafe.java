package exercicio6;

public class Cafe implements Produto {
    private static int idCafes = 1;
    private int anoProdução;
    private String categoria;
    private float preco;
    private int idLocal;

    public Cafe(int anoProdução, String categoria, float preco) {
        this.anoProdução = anoProdução;
        this.categoria = categoria;
        this.preco = preco;
        this.idLocal = idCafes;
        idCafes++;
    }

    @Override
    public String getID() {
        return anoProdução + "-" + idLocal;
    }

    @Override
    public int getAnoProdução() {
        return anoProdução;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public float getPreço() {
        return preco;
    }

    @Override
    public String mostra() {
        return "Café: ID=" + getID() + ", Ano de Produção=" + getAnoProdução() +
                ", Categoria=" + getCategoria() + ", Preço=" + getPreço();
    }

}

