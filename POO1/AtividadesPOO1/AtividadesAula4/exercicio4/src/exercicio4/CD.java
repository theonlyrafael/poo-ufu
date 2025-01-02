package exercicio4;

public class CD extends Midia {
    private String cantor;
    private int numeroFaixas;

    public CD(String nome, String genero, double precoLocacao, String cantor, int numeroFaixas) {
        super(nome, "Áudio", genero, precoLocacao);
        this.cantor = cantor;
        this.numeroFaixas = numeroFaixas;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getNumeroFaixas() {
        return numeroFaixas;
    }

    public void setNumeroFaixas(int numeroFaixas) {
        this.numeroFaixas = numeroFaixas;
    }
}
