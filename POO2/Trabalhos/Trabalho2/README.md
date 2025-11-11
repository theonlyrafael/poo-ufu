# Sistema de Gerenciamento de Locadora

> Trabalho desenvolvido em grupo durante o quarto período de Sistemas de Informação na Universidade Federal de Uberlândia (UFU), para a disciplina de Programação Orientada a Objetos 2.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat) ![Maven](https://img.shields.io/badge/Maven-Projeto-C71A36?style=flat) ![JUnit](https://img.shields.io/badge/JUnit-5.7.0-25A162?style=flat) ![Status](https://img.shields.io/badge/Status-Concluído-success?style=flat)

## Sobre o Projeto

O projeto implementa um sistema de gerenciamento de locadora executado pelo terminal.

O sistema permite administrar clientes, filmes, séries e locações, além de consultar a disponibilidade das mídias, registrar devoluções e calcular multas por atraso.

Os dados são mantidos em memória durante a execução do programa.

## Funcionalidades

* Cadastro de clientes.
* Cadastro de filmes e séries.
* Consulta de clientes pelo CPF.
* Consulta de mídias pelo código.
* Listagem das mídias disponíveis.
* Verificação da disponibilidade de uma mídia.
* Contagem de exemplares pelo título.
* Registro de novas locações.
* Exibição do histórico de locações.
* Devolução de mídias.
* Cálculo de multa por atraso.

## Regras de Locação

Cada locação registra:

* cliente responsável;
* mídia alugada;
* valor da locação;
* duração em dias;
* data da locação;
* data prevista para devolução.

A data de devolução é calculada a partir da data da locação e da quantidade de dias informada.

Quando uma mídia é devolvida depois da data prevista, o sistema calcula uma multa de **R$ 2,00 por dia de atraso**.

## Estrutura do Projeto

```text
Trabalho2/
├── demo/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   └── java/
│       │       └── com/
│       │           └── example/
│       │               ├── Cliente.java
│       │               ├── GerenciadorDeClientes.java
│       │               ├── GerenciadorDeLocacoes.java
│       │               ├── GerenciadorDeMidias.java
│       │               ├── IGerenciadorClientes.java
│       │               ├── IGerenciadorLocacoes.java
│       │               ├── IGerenciadorMidias.java
│       │               ├── Locacao.java
│       │               ├── Main.java
│       │               ├── Midia.java
│       │               ├── MidiaFilme.java
│       │               └── MidiaSerie.java
│       └── test/
│           └── java/
│               ├── GerenciadorDeClientesTeste.java
│               ├── GerenciadorDeLocacaoTeste.java
│               ├── GerenciadorMidiaTeste.java
│               └── LocacaoTeste.java
└── README.md
```

## Principais Classes

### `Cliente`

Representa um cliente da locadora, armazenando nome, CPF e endereço.

### `Midia`

Classe abstrata que reúne as informações comuns às mídias:

* título;
* duração;
* gêneros;
* tipo;
* setor;
* estado da locação.

### `MidiaFilme`

Representa um filme e acrescenta um código individual de identificação.

### `MidiaSerie`

Representa uma série e armazena uma lista de códigos para seus episódios.

### `Locacao`

Relaciona uma mídia a um cliente e registra valor, duração e data da locação.

Também calcula automaticamente a data prevista para devolução.

### `GerenciadorDeClientes`

Responsável por cadastrar clientes e realizar consultas pelo CPF.

### `GerenciadorDeMidias`

Responsável por cadastrar, consultar, contar e alugar mídias.

### `GerenciadorDeLocacoes`

Responsável por consultar datas de disponibilidade, registrar devoluções e calcular multas por atraso.

### `Main`

Inicializa os dados de exemplo e apresenta o menu interativo da locadora no terminal.

## Interfaces

O sistema utiliza interfaces para definir as operações dos gerenciadores:

* `IGerenciadorClientes`;
* `IGerenciadorMidias`;
* `IGerenciadorLocacoes`.

Essa separação estabelece os contratos que devem ser implementados pelas respectivas classes gerenciadoras.

## Testes

O projeto possui testes unitários desenvolvidos com JUnit 5 para verificar funcionalidades relacionadas a:

* cadastro e consulta de clientes;
* cadastro e consulta de mídias;
* verificação de disponibilidade;
* realização de locações;
* devolução de mídias;
* cálculo da data de devolução.

## Execução

> [!IMPORTANT]
> O projeto Maven está localizado dentro da pasta `demo`. Para que as dependências e a estrutura sejam reconhecidas corretamente, abra essa pasta como projeto no VS Code.

A classe principal é:

```text
demo/src/main/java/com/example/Main.java
```

Execute o método `main` e utilize o menu apresentado no terminal.

## Tecnologias

* Java 17.
* Apache Maven.
* JUnit 5.
* Java Collections.
* Java Time API.

