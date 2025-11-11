# QuickSort Genérico com Threads

> Trabalho desenvolvido em grupo durante o quarto período de Sistemas de Informação na Universidade Federal de Uberlândia (UFU), para a disciplina de Programação Orientada a Objetos 2.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat) ![Status](https://img.shields.io/badge/Status-Concluído-success?style=flat)

## Sobre o Projeto

O projeto implementa o algoritmo de ordenação **QuickSort** utilizando generics e múltiplas threads.

A implementação aceita vetores de diferentes tipos, desde que seus elementos possam ser comparados. Durante a ordenação, cada divisão do vetor cria threads independentes para processar suas partes esquerda e direita.

## Conceitos Aplicados

* Programação genérica com `Generics`.
* Restrição de tipos com `Comparable`.
* Criação e execução de threads.
* Sincronização com `join()`.
* Recursividade.
* Algoritmo de divisão e conquista.
* Ordenação pelo algoritmo QuickSort.

## Funcionamento

O algoritmo utiliza o último elemento do intervalo como pivô e reorganiza o vetor de maneira que:

* elementos menores ou iguais ao pivô fiquem à esquerda;
* elementos maiores fiquem à direita;
* o pivô seja colocado em sua posição definitiva.

Depois da partição, são criadas duas novas threads:

* uma para ordenar o lado esquerdo do vetor;
* outra para ordenar o lado direito.

A execução principal aguarda a conclusão das duas threads antes de continuar.

## Estrutura do Projeto

```text
Trabalho1/
├── src/
│   ├── Main.java
│   └── QuickSort.java
└── README.md
```

## Principais Classes

### `QuickSort`

Classe genérica responsável pela implementação do algoritmo.

A declaração:

```java
QuickSort<T extends Comparable<? super T>>
```

permite ordenar diferentes tipos de objetos que implementem `Comparable`.

A classe também estende `Thread`, permitindo que cada parte do vetor seja ordenada paralelamente.

### `Main`

Demonstra a utilização do algoritmo com:

* um vetor de números inteiros;
* um vetor de nomes.

Após a execução das threads, os dois vetores são exibidos em ordem crescente.

## Execução

Abra a pasta `Trabalho1` como um projeto Java e execute a classe:

```text
src/Main.java
```

A saída apresenta primeiro o vetor de números ordenado e, em seguida, o vetor de nomes em ordem alfabética.

