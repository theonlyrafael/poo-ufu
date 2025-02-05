package exercicio6;

public class Eletrodomestico implements Produto {
    private static int idEletrodomesticos = 1;
    private int anoProdução;
    private int unidadeVenda;
    private String categoria;
    private float preco;
    private int idLocal;

    public Eletrodomestico(int anoProdução, int unidadeVenda, String categoria, float preco) {
        this.anoProdução = anoProdução;
        this.unidadeVenda = unidadeVenda;
        this.categoria = categoria;
        this.preco = preco;
        this.idLocal = idEletrodomesticos;
        idEletrodomesticos++;
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
    public int getUnidadeVenda() {
        return unidadeVenda;
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
        return "Eletrodomestico: ID=" + getID() + ", Ano de Produção=" + getAnoProdução() +
                ", Unidade de Venda=" + getUnidadeVenda() + ", Categoria=" + getCategoria() +
                ", Preço=" + getPreço();
    }
}
