package exercicio3;

public class principalTempo {
    public static void main(String[] args) {
        // Criando um objeto da classe Tempo usando o construtor padrão
        Tempo tempo1 = new Tempo(16, 20, 40);
        System.out.println("Tempo 1: " + tempo1.formatarTempoCompleto()); // Tempo 1: 00:00:00 AM

        // Criando um objeto da classe Tempo usando o construtor com atributos já
        // configurados
        Tempo tempo2 = new Tempo(12, 30, 45);
        System.out.println("Tempo 2: " + tempo2.formatarTempoCompleto()); // Tempo 2: 12:30:45 PM

        // Testando o método incrementarMinuto
        tempo2.incrementarMinuto();
        System.out.println("Tempo 2 depois de incrementar um minuto: " + tempo2.formatarTempoCompleto()); 

        // Testando o método decrementarMinuto
        tempo2.decrementarMinuto();
        System.out.println("Tempo 2 depois de decrementar um minuto: " + tempo2.formatarTempoCompleto()); 
    }
}