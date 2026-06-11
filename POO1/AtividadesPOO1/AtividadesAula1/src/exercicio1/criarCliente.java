package exercicio1;

public class criarCliente {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;

    public void cadastrarCliente(String nome, String cpf, int idade, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
    }

    public void mostrarDadosCliente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Idade: " + this.idade);
        System.out.println("Telefone: " + this.telefone);
    }
}
