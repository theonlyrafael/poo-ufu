package exercicio6;

import java.util.Scanner;

public class PrincipalProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[100];

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar item à lista");
            System.out.println("2 - Calcular quantidade e preço total por categoria");
            System.out.println("3 - Calcular o total geral dos produtos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o tipo de produto (Café, Eletrodoméstico ou Vinho): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Informe o ano de produção: ");
                    int anoProdução = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Informe a categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("Informe o preço: ");
                    float preco = scanner.nextFloat();
                    scanner.nextLine();

                    if (tipo.equalsIgnoreCase("Café")) {
                        Café café = new Café(anoProdução, categoria, preco);
                        adicionarProduto(produtos, café);
                    } else if (tipo.equalsIgnoreCase("Eletrodoméstico")) {
                        System.out.println("Informe a unidade de venda: ");
                        int unidadeVenda = scanner.nextInt();
                        scanner.nextLine();
                        Eletrodoméstico eletrodoméstico = new Eletrodoméstico(anoProdução, unidadeVenda, categoria, preco);
                        adicionarProduto(produtos, eletrodoméstico);
                    } else if (tipo.equalsIgnoreCase("Vinho")) {
                        Vinho vinho = new Vinho(anoProdução);
                        adicionarProduto(produtos, vinho);
                    } else {
                        System.out.println("Tipo de produto inválido. Use 'Cafe', 'Eletrodomestico' ou 'Vinho'.");
                    }
                    break;

                case 2:
                    System.out.println("Informe a categoria para calcular a quantidade e preço total: ");
                    String categoriaInformada = scanner.nextLine();
                    int quantidadeCategoria = 0;
                    float precoTotalCategoria = 0;

                    for (Produto produto : produtos) {
                        if (produto != null && produto.getCategoria().equalsIgnoreCase(categoriaInformada)) {
                            quantidadeCategoria++;
                            precoTotalCategoria += produto.getPreço();
                        }
                    }

                    System.out.println("Quantidade de produtos na categoria '" + categoriaInformada + "': " + quantidadeCategoria);
                    System.out.println("Preço total da categoria '" + categoriaInformada + "': " + precoTotalCategoria);
                    break;

                case 3:
                    float totalGeral = 0;
                    for (Produto produto : produtos) {
                        if (produto != null) {
                            totalGeral += produto.getPreço();
                        }
                    }
                    System.out.println("Total geral dos produtos: " + totalGeral);
                    break;

                case 4:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);
    }

    private static void adicionarProduto(Produto[] produtos, Produto produto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = produto;
                System.out.println("Produto adicionado com sucesso!");
                return;
            }
        }
        System.out.println("Limite máximo de produtos atingido!");
    }
}
