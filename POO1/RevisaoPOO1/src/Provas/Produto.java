package Provas;

public abstract class Produto {
    private double preço;
    private String descrição;

    public Produto(double preço, String descrição) {
        this.preço = preço;
        this.descrição = descrição;
    }

    public double getPreço() {
        return preço;
    }

    public String getDescrição() {
        return "Descrição: " + descrição;
    }

}
