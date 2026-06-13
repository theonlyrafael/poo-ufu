package exercicio3;

public class Tempo {
    private int hora;
    private int minuto;
    private int segundo;

    // Construtor padrão
    public Tempo() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    // Construtor com atributos já configurados
    public Tempo(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    // Getter e Setter para o atributo hora
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23) {
            this.hora = hora;
        } else {
            this.hora = 0;
        }
    }

    // Getter e Setter para o atributo minuto
    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            this.minuto = 0;
        }
    }

    // Getter e Setter para o atributo segundo
    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
        } else {
            this.segundo = 0;
        }
    }

    // Método para mostrar o tempo no formato "hhmmss"
    public String formatarTempo() {
        String tempoFormatado = String.format("%02d:%02d:%02d", hora, minuto, segundo);
        return tempoFormatado;
    }

    // Método para mostrar o tempo no formato "hh:mm:ss AM ou PM"
    public String formatarTempoCompleto() {
        String periodo = "AM";
        int horaFormatada = hora;

        if (hora >= 12) {
            periodo = "PM";
            horaFormatada = horaFormatada - 12;
        }
        if (horaFormatada == 0) {
            horaFormatada = 12;
        }

        String tempoCompletoFormatado = String.format("%02d:%02d:%02d %s", horaFormatada, minuto, segundo, periodo);
        return tempoCompletoFormatado;
    }

    // Método para incrementar um minuto ao tempo
    public void incrementarMinuto() {
        minuto += 1;
        if (minuto == 60) {
            minuto = 0;
            hora += 1;
            if (hora == 24) {
                hora = 0;
            }
        }
    }

    // Método para decrementar um minuto ao tempo
    public void decrementarMinuto() {
        minuto -= 1;
        if (minuto == -1) {
            minuto = 59;
            hora -= 1;
            if (hora == -1) {
                hora = 23;
            }
        }
    }
}
