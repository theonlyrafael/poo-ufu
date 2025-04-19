package Prática5;

public class CalcImplementada implements Calculadora<Integer> {
    private Integer ultimoResultado;

    @Override
    public Integer soma(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtracao(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer multiplicacao(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divisao(Integer a, Integer b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Erro: divisão por zero");
            return null;
        }
    }

    @Override
    public Integer potencia(Integer base, Integer expoente) {
        return (int) Math.pow(base, expoente);
    }

    @Override
    public Integer raizQuadratica(Integer numero) {
        if (numero >= 0) {
            return (int) Math.sqrt(numero);
        } else {
            System.out.println("Erro: não é possível calcular a raiz quadrática de um número negativo");
            return null;
        }
    }

    @Override
    public Integer raizCubica(Integer numero) {
        return (int) Math.cbrt(numero);
    }

    @Override
    public Integer fatorial(Integer numero) {
        if (numero < 0) {
            System.out.println("Erro: não é possível calcular o fatorial de um número negativo");
            return null;
        }

        int resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }

        return resultado;
    }

    @Override
    public Integer fibonacci(Integer n) {
        if (n < 0) {
            System.out.println("Erro: não é possível calcular o termo " + n + " da sequência de Fibonacci");
            return null;
        }

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int fib1 = 0, fib2 = 1, fibAtual = 0;
        for (int i = 2; i <= n; i++) {
            fibAtual = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibAtual;
        }

        return fibAtual;
    }

    @Override
    public Integer progressaoAritmetica(Integer a1, Integer r, Integer n) {
        return a1 + (n - 1) * r;
    }

    @Override
    public Integer progressaoGeometrica(Integer a1, Integer r, Integer n) {
        return a1 * (int) Math.pow(r, n - 1);
    }

    public void setUltimoResultado(Integer resultado) {
        this.ultimoResultado = resultado;
    }

    public Integer getUltimoResultado() {
        return ultimoResultado;
    }

}