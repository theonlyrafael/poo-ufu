package Prática2;

public class MultiVetor implements Runnable{
    private double[] vetor;
    private double escalar;
    private int inicio;
    private int fim;

    public MultiVetor(double[] vetor, double escalar, int inicio, int fim) {
        this.vetor = vetor;
        this.escalar = escalar;
        this.inicio = inicio;
        this.fim = fim;
    }

    public double[] getVetor() {
        return vetor;
    }

    public double getEscalar() {
        return escalar;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    public void setVetor(double[] vetor) {
        this.vetor = vetor;
    }

    public void setEscalar(double escalar) {
        this.escalar = escalar;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }
    
    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            vetor[i] *= escalar;
        }
    }
}


