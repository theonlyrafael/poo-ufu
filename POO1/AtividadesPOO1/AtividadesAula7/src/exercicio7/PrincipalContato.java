package exercicio7;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class PrincipalContato {

    private static String caminhoArquivo = "D:\\Java\\AulaPratica7\\src\\Classes7\\ArquivosEmpregados\\contatos";

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
            while (linha != null) {
                linha = reader.readLine();
            }
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(texto + "\n");
            writer.flush();
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

    public static ArrayList<Contato> carregaDados(String caminho) {
        String linha;
        BufferedReader arquivo = null;
        ArrayList<Contato> lista = new ArrayList<>();
        try {
            File file = new File(caminho);
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    arquivo = new BufferedReader(new FileReader(f));
                    do {
                        linha = arquivo.readLine();
                        lista.add(new Contato(linha));
                    } while (linha != null);
                }
            } else {
                arquivo = new BufferedReader(new FileReader(file));
                do {
                    linha = arquivo.readLine();
                    lista.add(new Contato(linha));
                } while (linha != null);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado para carregamento!");
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
        return lista;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestaoContatos gestaoContatos = new GestaoContatos();
        ArrayList<Contato> contatos = carregaDados(caminhoArquivo);
        if (contatos == null)
            contatos = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getNome() != null)
                gestaoContatos.adicionaContato(contato, contato.getTipoContato());
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
                        Contato novoContato = new Contato(nome, profissao, telefone, email, tipoContato, idade, sexo);
                        contatos.add(novoContato);
                        gestaoContatos.adicionaContato(novoContato, tipoContato);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida");
                    } catch (InvalidParameterException e) {
                        System.out.println("Tipo de contato invalido");
                    } catch (Exception e) {
                        System.out.println("Erro desconhecido");
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
                        for (Contato contato : contatos) {
                            if (contato.getNome().equalsIgnoreCase(nome)) {
                                contatos.remove(contato);
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
                    for (Contato contato : contatos) {
                        if (contato.getNome() != null)
                            salvarTexto(caminhoArquivo,
                                    contato.getNome() + "###" + contato.getProfissao() + "###" + contato.getTelefone()
                                            + "###" + contato.getEmail() + "###" + contato.getTipoContato() + "###"
                                            + contato.getIdade() + "###" + contato.getSexo());
                    }
                    break;
            }
        }
        sc.close();
    }
}
