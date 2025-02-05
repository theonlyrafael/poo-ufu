package Provas;

import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalProduto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produto> p = new ArrayList<>();
        int op;

        do {
            System.out.println("Menu:");
            System.out.println("1) Inserir Livro");
            System.out.println("2) Inserir Mouse");
            System.out.println("3) Visualizar Produtos");
            System.out.println("0) Sair");

            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    sc.nextLine(); // Limpar o buffer
                    String tituloLivro = sc.nextLine();
                    p.add(new Livro(tituloLivro));
                    break;
                case 2:
                    System.out.println("Digite o tipo do mouse:");
                    sc.nextLine(); // Limpar o buffer
                    String tipoMouse = sc.nextLine();
                    p.add(new Mouse(tipoMouse));
                    break;
                case 3:
                    System.out.println("Produtos no Carrinho:");
                    for (Produto produto : p) {
                        if (produto instanceof Livro) {
                            Livro livro = (Livro) produto;
                            System.out.println(produto.getDescrição() + " - " + livro.getTítulo() + " : " + "R$" +produto.getPreço());
                        } else if (produto instanceof Mouse) {
                            Mouse mouse = (Mouse) produto;
                            System.out.println(produto.getDescrição() + " - " + mouse.getTipo() + " : " + "R$" +produto.getPreço());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            } 
        
        } while (op!=0);
                
    }
    
}
