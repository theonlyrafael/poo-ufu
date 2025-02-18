package Main;

import java.util.HashMap;
import java.util.Map;

public class Colégio {

    private Map<Integer, Integer> classe;
    private Map<String, String> alunos;

    public Colégio() {
        this.classe = new HashMap<>();
        this.alunos = new HashMap<>();
    }

    public <K, V> void adicionarElemento(Map<K, V> mapa, K chave, V valor) {
        mapa.put(chave, valor);
    }

    public <K, V> void imprimirElementos(Map<K, V> mapa) {
        for (Map.Entry<K, V> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<Integer, Integer> getClasse() {
        return classe;
    }

    public Map<String, String> getAlunos() {
        return alunos;
    }
}

