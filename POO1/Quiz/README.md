# Quiz em Java

> Trabalho em grupo desenvolvido durante o terceiro período do curso de Sistemas de Informação na Universidade Federal de Uberlândia (UFU), para a disciplina de Programação Orientada a Objetos 1.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat) ![Status](https://img.shields.io/badge/Status-Concluído-success?style=flat)

## Sobre o Projeto

O projeto implementa um jogo de perguntas e respostas executado pelo terminal. As perguntas são divididas por assuntos e níveis de dificuldade, enquanto a pontuação recebida por cada acerto varia de acordo com a dificuldade selecionada.

O sistema também permite cadastrar administradores, adicionar novas perguntas ao banco do jogo, registrar jogadores e exibir um ranking baseado nas pontuações obtidas.

## Funcionalidades

* Cadastro de administradores.
* Cadastro de perguntas e alternativas.
* Carregamento de perguntas e respostas a partir de arquivos de texto.
* Partidas com um a quatro jogadores.
* Realização de cinco rodadas por partida.
* Seleção aleatória de perguntas.
* Pontuação baseada no nível de dificuldade.
* Armazenamento da pontuação dos jogadores.
* Ordenação e exibição do ranking.

## Sistema de Pontuação

| Dificuldade | Pontuação |
|---|---:|
| Fácil | 10 pontos |
| Média | 20 pontos |
| Difícil | 30 pontos |

## Estrutura do Projeto

```text
Quiz/
├── src/
│   ├── Jogo/
│   │   └── Jogo.java
│   ├── Pergunta/
│   │   └── Pergunta.java
│   ├── Quiz/
│   │   └── MainQuiz.java
│   ├── Resposta/
│   │   └── Resposta.java
│   └── Usuarios/
│       ├── Administrador.java
│       ├── Jogador.java
│       └── Usuarios.java
├── administradores.txt
├── jogadores.txt
├── pergunta.txt
├── ranking.txt
├── resposta.txt
└── README.md
```

## Principais Classes

* **`MainQuiz`**: contém o menu principal, carrega os arquivos de dados e controla o fluxo do programa.
* **`Jogo`**: controla as rodadas, seleciona perguntas, verifica respostas e atualiza as pontuações.
* **`Pergunta`**: representa o assunto, o enunciado, a dificuldade e a pontuação de uma pergunta.
* **`Resposta`**: armazena as quatro alternativas e o índice da resposta correta.
* **`Usuarios`**: classe abstrata que representa os dados comuns dos usuários.
* **`Administrador`**: permite cadastrar administradores, perguntas e respostas.
* **`Jogador`**: armazena a pontuação e permite ordenar os participantes no ranking.

## Arquivos de Dados

O projeto utiliza arquivos de texto como uma forma simples de persistência:

| Arquivo | Conteúdo |
|---|---|
| `administradores.txt` | Administradores cadastrados no sistema |
| `jogadores.txt` | Jogadores e suas pontuações acumuladas |
| `pergunta.txt` | Assunto, enunciado e dificuldade das perguntas |
| `resposta.txt` | Alternativas e índice da resposta correta |
| `ranking.txt` | Pontuações utilizadas na exibição do ranking |

As perguntas e respostas são relacionadas pela posição das linhas. Dessa forma, a primeira linha de `pergunta.txt` corresponde à primeira linha de `resposta.txt`, e assim sucessivamente.

> [!IMPORTANT]
> Os arquivos `.txt` devem permanecer na raiz do projeto, pois o programa utiliza caminhos relativos para encontrá-los.

## Execução

O projeto utiliza Java 17.

Para executá-lo:

1. Abra a pasta do projeto em uma IDE compatível com Java.
2. Confirme que o JDK 17 está instalado e configurado.
3. Execute a classe `Quiz.MainQuiz`.
4. Utilize o menu exibido no terminal para cadastrar administradores, adicionar perguntas ou iniciar uma partida.

