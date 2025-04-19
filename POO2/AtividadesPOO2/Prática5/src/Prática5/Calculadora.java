package Prática5;

public interface Calculadora<T extends Number> {
    T soma(T a, T b);

    T subtracao(T a, T b);

    T multiplicacao(T a, T b);

    T divisao(T a, T b);

    T potencia(T base, T expoente);

    T raizQuadratica(T numero);

    T raizCubica(T numero);

    T fatorial(T numero);

    T fibonacci(T n);

    T progressaoAritmetica(T a1, T r, T n);

    T progressaoGeometrica(T a1, T r, T n);

    public void setUltimoResultado(Integer resultado);
}