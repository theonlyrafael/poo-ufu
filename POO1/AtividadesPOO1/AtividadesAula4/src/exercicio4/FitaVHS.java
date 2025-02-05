package exercicio4;

public class FitaVHS extends Midia {
    private boolean rebobinada;

    public FitaVHS(String nome, String genero, double precoLocacao, boolean rebobinada) {
        super(nome, "Vídeo", genero, precoLocacao);
        this.rebobinada = rebobinada;
    }

    // Getters e setters para o atributo específico de VHS

    public boolean isRebobinada() {
        return rebobinada;
    }

    public void setRebobinada(boolean rebobinada) {
        this.rebobinada = rebobinada;
    }
}