package Provas;

public class eletrodoméstico implements Produtos {
    private String id;
    private int anodeProdução;
    private int unidadeVenda;
    private String categoria;
    private double preço;

    public eletrodoméstico(String id, int ap, int uv, String c, double p) {
        this.id = id;
        this.anodeProdução = ap;
        this.unidadeVenda = uv;
        this.categoria = c;
        this.preço = p;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public int getAnoProdução() {
        return anodeProdução;
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
    public double getPreço() {
        return preço;
    }
    
}
