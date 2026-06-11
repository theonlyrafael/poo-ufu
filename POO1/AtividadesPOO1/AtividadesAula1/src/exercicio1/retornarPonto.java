package exercicio1;

public class retornarPonto {
    public static void main(String[] args) {
        Ponto ponto1 = new Ponto();
        ponto1.inicializarCoordenadas(7.0, 3.5);

        Ponto ponto2 = new Ponto();
        ponto2.inicializarCoordenadas(4.0, 8.0);

        double distancia = ponto1.calcularDistancia(ponto2);

        System.out.println("A distância entre os pontos é: " + distancia);
    }
}