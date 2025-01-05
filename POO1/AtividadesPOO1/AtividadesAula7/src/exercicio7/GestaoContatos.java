package exercicio7;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class GestaoContatos {
    private ArrayList<Contato> familia, amigos, profissional;

    public GestaoContatos() {
        familia = new ArrayList<>();
        amigos = new ArrayList<>();
        profissional = new ArrayList<>();
    }

    public void adicionaContato(Contato contato, String tipoLista) throws InvalidParameterException {
        if (tipoLista != null && tipoLista.equals("familia")) {
            familia.add(contato);
        } else if (tipoLista != null && tipoLista.equals("amigos")) {
            amigos.add(contato);
        } else if (tipoLista != null && tipoLista.equals("profissional")) {
            profissional.add(contato);
        } else {
            throw new InvalidParameterException();
        }
    }

    public void eliminaContato(String nome, String tipoLista) throws ContatoNaoEncontradoException {
        ArrayList<Contato> lista = null;
        if (tipoLista.equals("familia")) {
            lista = familia;
        } else if (tipoLista.equals("amigos")) {
            lista = amigos;
        } else if (tipoLista.equals("profissional")) {
            lista = profissional;
        }

        if (lista != null) {
            for (Contato contato : lista) {
                if (contato.getNome().equalsIgnoreCase(nome)) {
                    lista.remove(contato);
                    return;
                }
            }
        }

        throw new ContatoNaoEncontradoException();
    }

    public String listaContatos(String tipoLista) {
        ArrayList<Contato> lista = null;
        if (tipoLista.equals("familia")) {
            lista = familia;
        } else if (tipoLista.equals("amigos")) {
            lista = amigos;
        } else if (tipoLista.equals("profissional")) {
            lista = profissional;
        }

        if (lista != null) {
            String listaContatos = "";
            for (Contato contato : lista) {
                listaContatos += contato.toString() + "\n";
            }
            return listaContatos;
        } else {
            return "";
        }
    }

    public String toString() {
        return "Familia:\n" + listaContatos("familia") + "\nAmigos:\n" + listaContatos("amigos") + "\nProfissional:\n"
                + listaContatos("profissional");
    }

    public String maisVelho(String tipoLista) {
        ArrayList<Contato> lista = null;
        if (tipoLista.equals("familia")) {
            lista = familia;
        } else if (tipoLista.equals("amigos")) {
            lista = amigos;
        } else if (tipoLista.equals("profissional")) {
            lista = profissional;
        }

        if (lista != null && !lista.isEmpty()) {
            Contato maisVelho = lista.get(0);
            for (Contato contato : lista) {
                if (contato.getIdade() > maisVelho.getIdade()) {
                    maisVelho = contato;
                }
            }
            return maisVelho.toString();
        } else {
            return "";
        }
    }

    public String maisNovo(String tipoLista) {
        ArrayList<Contato> lista = null;
        if (tipoLista.equals("familia")) {
            lista = familia;
        } else if (tipoLista.equals("amigos")) {
            lista = amigos;
        } else if (tipoLista.equals("profissional")) {
            lista = profissional;
        }

        if (lista != null && !lista.isEmpty()) {
            Contato maisNovo = lista.get(0);
            for (Contato contato : lista) {
                if (contato.getIdade() < maisNovo.getIdade()) {
                    maisNovo = contato;
                }
            }
            return maisNovo.toString();
        } else {
            return "";
        }
    }
}
