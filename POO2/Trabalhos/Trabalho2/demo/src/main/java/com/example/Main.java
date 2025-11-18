package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Add Midias
        ArrayList<Midia> midias = new ArrayList<>();

        MidiaFilme filme1 = new MidiaFilme("Vingadores", 150, new String[] { "Ação,Herois" }, "DVD", 1, true, 001);
        MidiaFilme filme2 = new MidiaFilme("De volta para o Futuro", 90, new String[] { "Comédia, FIcção" },
                "Fita Cassete", 2, true, 002);
        MidiaFilme filme3 = new MidiaFilme("Poderoso Chefão", 120, new String[] { "Ação,Mafia" }, "DVD", 1, false, 003);
        midias.add(filme1);
        midias.add(filme2);
        midias.add(filme3);

        MidiaSerie serie1 = new MidiaSerie("The office", 45, new String[] { "Comedia" }, "DVD", 1, true,
                List.of(101, 102, 103, 104, 105));
        MidiaSerie serie2 = new MidiaSerie("Friends", 60, new String[] { "Comedia" }, "Fita Cassete", 2, false,
                List.of(201, 202, 203));
        midias.add(serie1);
        midias.add(serie2);

        // ADD clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("João Silva", "111.111.111-00",
                new String[] { "Rua A, 123", "Bairro X", "12345-678", "Casa" });
        Cliente cliente2 = new Cliente("Maria Souza", "222.222.222-00",
                new String[] { "Rua B, 456", "Bairro Y", "12345-678", "Apt" });
        Cliente cliente3 = new Cliente("Jonas Costa", "333.333.333-00",
                new String[] { "Rua C, 789", "Bairro Z", "12345-678", "Apt" });
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Add Locação
        ArrayList<Locacao> locacoes = new ArrayList<>();

        Locacao locacao1 = new Locacao(filme1, cliente1, 10.00, 3, LocalDate.of(2024, 3, 25));
        Locacao locacao2 = new Locacao(serie2, cliente2, 8.50, 5, LocalDate.of(2024, 3, 27));
        locacoes.add(locacao1);
        locacoes.add(locacao2);

        GerenciadorDeMidias gm = new GerenciadorDeMidias(midias);
        GerenciadorDeClientes gc = new GerenciadorDeClientes(clientes);
        GerenciadorDeLocacoes gl = new GerenciadorDeLocacoes(locacoes);

        
        // LocadoraFuncionamento locadora = new LocadoraFuncionamento(midias, clientes, locacoes);
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;


        do {
            System.out.println("Escolha uma opção:");
            System.err.println("1. Cadastrar nova Midia");
            System.out.println("2. Cadastrar novo Cliente");
            System.out.println("3. Consultar dados do produto");
            System.out.println("4. Consultar dados do Cliente");
            System.out.println("5. Verificar se um produto está alugado ou não, e que data ele estará disponível");
            System.out.println("6. Verificar quantos produtos com o mesmo título existem");
            System.out.println("7. Verificar midias disponiveis: ");
            System.out.println("8. Alugar midia");
            System.out.println("9. Historico de locacoes");
            System.out.println("10. Devolver midia");
            System.out.println("0. Sair");
            System.out.print("\nDigite a opção:");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("---Cadastrar novo filme ou série---");

                    System.out.println("Deseja cadastrar um filme ou série? (f/s)");
                    String tipoMidia = scanner.next();

                    // Leitura de dados básicos
                    System.out.println("Digite o título:");
                    scanner.nextLine(); // Limpar buffer
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o tempo de fita (em minutos):");
                    int tempFita = scanner.nextInt();

                    System.out.println("Digite os gêneros (separados por vírgula):");
                    String generosStr = scanner.next();
                    String[] generos = generosStr.split(",");

                    System.out.println("Digite o tipo (Fita cassete ou DVD):");
                    String tipo = scanner.next();

                    System.out.println("Digite o setor:");
                    int setor = scanner.nextInt();

                    System.out.println("A mídia está alugada? (s/n)");
                    boolean alugado = scanner.next().equalsIgnoreCase("s");

                    // Leitura de dados específicos
                    if (tipoMidia.equalsIgnoreCase("f")) {
                        // Cadastrar filme
                        System.out.println("Digite o código do filme:");
                        int codigoFilme = scanner.nextInt();

                        MidiaFilme novoFilme = new MidiaFilme(titulo, tempFita, generos, tipo, setor,
                                alugado,
                                codigoFilme);
                        gm.inserirMidia(novoFilme);

                        System.out.println("Filme cadastrado com sucesso!");
                    } else if (tipoMidia.equalsIgnoreCase("s")) {
                        // Cadastrar série
                        System.out.println("Digite os códigos dos episódios (separados por vírgula):");
                        String codigosStr = scanner.next();
                        String[] codigos = codigosStr.split(",");

                        List<Integer> codigosList = new ArrayList<>();
                        for (String codigo : codigos) {
                            codigosList.add(Integer.parseInt(codigo));
                        }

                        MidiaSerie novaSerie = new MidiaSerie(titulo, tempFita, generos, tipo, setor,
                                alugado,
                                codigosList);
                        gm.inserirMidia(novaSerie);

                        System.out.println("Série cadastrada com sucesso!");
                    } else {
                        System.out.println("Tipo de mídia inválido!");
                    }

                    break;

                case 2:
                    System.out.println("---Cadastro de novo cliente---");
                    System.out.println("Digite o nome do cliente:");
                    String nomeNovoCliente = scanner.next();
                    System.out.println("Digite o CPF do cliente:");
                    String cpfNovoCliente = scanner.next();
                    System.out.println("Digite o endereço do cliente(Rua/AV, número, Bairro, CEP, complemento):");
                    scanner.nextLine();
                    String enderecoStr = scanner.nextLine();
                    String[] endereco = enderecoStr.split(",");

                    Cliente novoCliente = new Cliente(nomeNovoCliente, cpfNovoCliente, endereco);

                    gc.inserirCliente(novoCliente);

                    System.out.println("Novo cliente cadastrado com sucesso!");
                    break;

                case 3:
                    System.out.println("Digite o código do produto:");
                    int codigoProduto = scanner.nextInt();
                    String produto = gm.consultarProduto(codigoProduto);
                    System.out.println(produto);
                    break;
                case 4:
                    System.out.println("Digite o CPF do cliente:");
                    String cpfCliente = scanner.next();
                    String cliente = gc.consultarCliente(cpfCliente);
                    System.out.println(cliente);
                    break;
                case 5:
                    System.out.println("Digite o código do produto:");
                    int codigoProdutoAlugado = scanner.nextInt();
                    boolean isAlugado = gm.verificarProdutoAlugado(codigoProdutoAlugado);
                    LocalDate dataDisponivel = gl.verificarDataDisponibilidade(codigoProdutoAlugado, midias);

                    if (isAlugado) {
                        System.out.println(
                                "O produto está alugado e estara disponivel a partir do data: " + dataDisponivel + " ou apos o cliente pagar a multa e devolver");
                    } else {
                        System.out.println("O produto não está alugado, logo esta disponivel para locacao.");
                    }
                    break;
                case 6:
                    System.out.println("Digite o título do produto:");
                    scanner.nextLine(); // limpar buffer
                    String tituloProduto = scanner.nextLine();
                    int quantidade = gm.contarProdutosPorTitulo(tituloProduto);
                    System.out.println("Quantidade de produtos com o mesmo título: " + quantidade);
                    break;
                case 7:
                    System.out.println("Midias disponiveis: ");
                    for (Midia midia : midias) {
                        if (!midia.getAlugado()) {
                            if (midia instanceof MidiaFilme) {
                                MidiaFilme filme = (MidiaFilme) midia;
                                System.out.println("Título: " + midia.getTitulo() + " | Código: " + filme.getCodigo());
                            } else if (midia instanceof MidiaSerie) {
                                MidiaSerie serie = (MidiaSerie) midia;
                                System.out
                                        .println("Título: " + midia.getTitulo() + " | Códigos: " + serie.getCodigos());
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Digite o codigo da midia que deseja alugar:");
                    int codigoMidia = scanner.nextInt();

                    System.out.println("Digite o CPF do cliente que está alugando a mídia:");
                    String cpfCli = scanner.next();

                    System.out.println("Digite o preco:");
                    double preco = scanner.nextDouble();

                    System.out.println("Digite o tempo de locacao:");
                    int tempoLocacao = scanner.nextInt();

                    Locacao l = gm.alugarMidia(codigoMidia, cpfCli, preco, tempoLocacao, clientes);

                    if( l != null){
                        locacoes.add(l);
                        System.out.println("Midia alugada com sucesso!");
                    }else{
                        System.out.println("Midia não disponivel para aluguel ou Usuario nao encontrado.");
                    }
                    break;
                case 9:
                    System.out.println("Histórico de locações:");
                    for (Locacao locacao : locacoes) {
                        System.out.println("Cliente: " + locacao.getCliente().getNome());
                        System.out.println("Mídia: " + locacao.getMidias().getTitulo());
                        System.out.println("Valor: " + locacao.getValor());
                        System.out.println("Tempo de locação: " + locacao.getTempLocacao());
                        System.out.println("Data de locação: " + locacao.getDataLocacao());
                        System.out.println("Data de devolução: " + locacao.getDataDevolucao());
                        System.out.println();
                    }
                    break;
                case 10:
                    System.out.println("---Devolver uma mídia---");

                    System.out.println("Digite o código da mídia que você deseja devolver:");
                    int codigoMD = scanner.nextInt();

                    String resultado = gl.devolverMidia(codigoMD);
                    System.out.println(resultado);

                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}