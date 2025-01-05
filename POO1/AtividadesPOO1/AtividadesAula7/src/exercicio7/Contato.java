package exercicio7;

public class Contato {
    private String nome, profissao, telefone, email, tipoContato;
    private int idade;
    private char sexo;

    public Contato(String nome, String profissao, String telefone, String email, String tipoContato, int idade,
            char sexo) {
        this.nome = nome;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
        this.tipoContato = tipoContato;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Contato(String linha) {
        if (linha != null) {
            String valores[] = linha.split(" ### ");
            this.nome = valores[0];
            this.profissao = valores[1];
            this.telefone = valores[2];
            this.email = valores[3];
            this.tipoContato = valores[4];
            this.idade = Integer.parseInt(valores[5]);
            this.sexo = valores[6].charAt(0);
        }
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public String toString() {
        return nome + ", " + idade + " anos, " + "sexo " + sexo + ", " + profissao + ", " + "telefone n. " + telefone
                + ", e-mail: " + email;
    }
}
