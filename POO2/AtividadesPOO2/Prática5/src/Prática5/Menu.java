package Prática5;

public class Menu {
    public static void main(String[] args) {
        CalcImplementada calculadora1 = new CalcImplementada();

        ThreadCalc threadCalc1 = new ThreadCalc(calculadora1);
        threadCalc1.start();

        try {
            threadCalc1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}