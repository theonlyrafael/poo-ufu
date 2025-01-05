package exercicio7;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class PrincipalContatoHashMap {

    private static String caminhoArquivo = "D:\\Java\\AulaPratica7\\src\\Classes7\\ArquivosEmpregados\\contatosHashMap";

    public static void salvarTexto(String caminho, String texto) {
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            File file = new File(caminho);
            if (!file.exists()) {
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String linha = reader.readLine();
            String[] valoresArquivo;
            String[] valoresTexto = texto.split(" ### ");
            int flag = 0;
            while (linha != null) {
                valoresArquivo = linha.split(" ### ");
                if (valoresArquivo[2].equals(valoresTexto[2])) {
                    flag = 1;
                    break;
                }
                linha = reader.readLine();
            }
            if (flag == 0) {
                writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(texto + "\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static HashMap<String, Contato> carregaDados(String caminho) {
        String linha;
        BufferedReader arquivo = null;
        HashMap<String, Contato> mapaContatos = new HashMap<>();
        try {
            File file = new File(caminho);
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    arquivo = new BufferedReader(new FileReader(f));
                    do {
                        linha = arquivo.readLine();
                        Contato contato = new Contato(linha);
                        String tipoContato = contato.getTipoContato();
                        if (!mapaContatos.containsKey(tipoContato)) {
                            mapaContatos.put(tipoContato, contato);
                        }
                        mapaContatos.put(contato.getTelefone(), contato);
                    } while (linha != null);
                }
            } else
                arquivo = new BufferedReader(new FileReader(file));
            do {
                linha = arquivo.readLine();
                Contato contato = new Contato(linha);
                String telefone = contato.getTelefone();
                if (linha == null)
                    break;
                if (!mapaContatos.containsKey(telefone)) {
                    mapaContatos.put(telefone, contato);
                }
                mapaContatos.put(contato.getTelefone(), contato);
            } while (linha != null);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado para carregamento");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (arquivo != null) {
                    arquivo.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapaContatos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Contato> mapaContatos = carregaDados(caminhoArquivo);
        if (mapaContatos == null)
            mapaContatos = new HashMap<>();
        GestaoContatos gestaoContatos = new GestaoContatos();
        for (Contato contatos : mapaContatos.values()) {
            if (contatos.getTelefone() != null) {
                gestaoContatos.adicionaContato(contatos, contatos.getTipoContato());
            }
        }
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Listar contatos por tipo");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("5 - Listar contato mais velho");
            System.out.println("6 - Listar contato mais novo");
            System.out.println("0 - Sair");
            System.out.print(">: ");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida");
                sc.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    try {
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Profissao: ");
                        String profissao = sc.next();
                        System.out.print("Telefone: ");
                        String telefone = sc.next();
                        System.out.print("Email: ");
                        String email = sc.next();
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        System.out.print("Sexo [M/F]: ");
                        char sexo = sc.next().charAt(0);
                        System.out.print("Tipo de contato [familia/amigos/profissional]: ");
                        String tipoContato = sc.next();
                        if (!tipoContato.equalsIgnoreCase("familia") && !tipoContato.equalsIgnoreCase("amigos")
                                && !tipoContato.equalsIgnoreCase("profissional")) {
                            throw new InvalidParameterException();
                        }
                        Contato contato = new Contato(nome, profissao, telefone, email, tipoContato, idade, sexo);
                        mapaContatos.put(telefone, contato);
                        gestaoContatos.adicionaContato(contato, tipoContato);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Nome: ");
                        String nome = sc.next();
                        System.out.print("Tipo de contato [familia/amigos/profissional]: ");
                        String tipoContato = sc.next();
                        if (!tipoContato.equalsIgnoreCase("familia") && !tipoContato.equalsIgnoreCase("amigos")
                                && !tipoContato.equalsIgnoreCase("profissional")) {
                            throw new InvalidParameterException();
                        }
                        gestaoContatos.eliminaContato(nome, tipoContato);
                        for (Contato contatos : mapaContatos.values()) {
                            if (contatos.getNome().equalsIgnoreCase(nome)
                                    && contatos.getTipoContato().equalsIgnoreCase(tipoContato)) {
                                mapaContatos.remove(contatos.getTelefone());
                                break;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println("Contato não encontrado");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Tipo de contato [familia/amigos/profissional]: ");
                        String tipoContato = sc.next();
                        if (!tipoContato.equalsIgnoreCase("familia") && !tipoContato.equalsIgnoreCase("amigos")
                                && !tipoContato.equalsIgnoreCase("profissional")) {
                            throw new InvalidParameterException();
                        }
                        System.out.println(gestaoContatos.listaContatos(tipoContato));
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                    }
                    break;
                case 4:
                    try {
                        System.out.println(gestaoContatos.toString());
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Tipo de contato [familia/amigos/profissional]: ");
                        String tipoContato = sc.next();
                        if (!tipoContato.equalsIgnoreCase("familia") && !tipoContato.equalsIgnoreCase("amigos")
                                && !tipoContato.equalsIgnoreCase("profissional")) {
                            throw new InvalidParameterException();
                        }
                        System.out.println(gestaoContatos.maisVelho(tipoContato));
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Tipo de contato [familia/amigos/profissional]: ");
                        String tipoContato = sc.next();
                        if (!tipoContato.equalsIgnoreCase("familia") && !tipoContato.equalsIgnoreCase("amigos")
                                && !tipoContato.equalsIgnoreCase("profissional")) {
                            throw new InvalidParameterException();
                        }
                        System.out.println(gestaoContatos.maisNovo(tipoContato));
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    for (Contato contatos : mapaContatos.values()) {
                        if (contatos.getTelefone() != null) {
                            salvarTexto(caminhoArquivo,
                                    contatos.getNome() + " ### " + contatos.getProfissao() + " ### "
                                            + contatos.getTelefone() + " ### " + contatos.getEmail() + " ### "
                                            + contatos.getTipoContato() + " ### " + contatos.getIdade() + " ### "
                                            + contatos.getSexo());
                        }
                    }
                    break;
            }
        }
        sc.close();
    }
}