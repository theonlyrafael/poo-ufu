package exercicio3;

public class máquinadepassagens {
    private int preço;
    private int quantInserida;
    public int total;

    public máquinadepassagens(int p) {
        preço = p;
        quantInserida = 0;
        total = 0;
    }

    public void inserirDinheiro(int quant) {
        quantInserida += quant;
        if (quantInserida == preço) {
            emitirPassagem();
        } else if (quantInserida < preço) {
            int restante = preço - quantInserida;
            System.out.println("Faltam R$" + restante + " para emitir a passagem.");
        } else {
            int troco = quantInserida - preço;
            System.out.println("O troco da passagem foi de R$" + troco);
            emitirPassagem();
        }
    }

    public void emitirPassagem() {
        total += preço;
        quantInserida = 0;
        System.out.println("Passagem emitida com sucesso!");
    }

    public void mostrarPreco() {
        System.out.println("O preço da passagem é R$" + preço);
    }

    /*public void devolverTroco() {
        if (quantInserida > preço) {
            int troco = quantInserida - preço;
            System.out.println("O troco da passagem foi de R$" + troco);
        }
    }*/
}
