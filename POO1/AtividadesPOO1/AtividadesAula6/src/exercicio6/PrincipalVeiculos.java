package exercicio6;

public class PrincipalVeículos {
    public static void main(String[] args) {
        Veículo[] veiculos = new Veículo[5];
        veiculos[0] = new Carro("Ford", "Focus", "Vermelho", 150.0);
        veiculos[1] = new Carro("Toyota", "Corolla", "Azul", 180.0);
        veiculos[2] = new Moto("Honda", "CBR", "Vermelho", 100.0);
        veiculos[3] = new Carro("Volkswagen", "Golf", "Vermelho", 160.0);
        veiculos[4] = new Moto("Yamaha", "YZF", "Preto", 120.0);

        double potenciaMaxima = -1.0;
        double potenciaMinima = Double.MAX_VALUE;
        String marcaMaisPotente = "";
        String marcaMenosPotente = "";

        for (Veículo veiculo : veiculos) {
            if (veiculo.cor().equalsIgnoreCase("Vermelho")) {
                veiculo.mostraDados();
                if (veiculo.potencia() > potenciaMaxima) {
                    potenciaMaxima = veiculo.potencia();
                    marcaMaisPotente = veiculo.marca();
                }
                if (veiculo.potencia() < potenciaMinima) {
                    potenciaMinima = veiculo.potencia();
                    marcaMenosPotente = veiculo.marca();
                }
            }
        }

        System.out.println("Marca do veículo vermelho mais potente: " + marcaMaisPotente);
        System.out.println("Marca do veículo vermelho menos potente: " + marcaMenosPotente);
    }
}