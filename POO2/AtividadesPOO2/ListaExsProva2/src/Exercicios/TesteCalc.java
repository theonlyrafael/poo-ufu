package Exercicios;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.Calc;

public class TesteCalc {

    @Test
    public void testSoma() {
        Calc calc = new Calc();
        assertEquals(5, calc.soma(2, 3));
        assertEquals(-1, calc.soma(-3, 2));
        assertEquals(0, calc.soma(0, 0));
    }

    @Test
    public void testSub() {
        Calc calc = new Calc();
        assertEquals(1, calc.sub(3, 2));
        assertEquals(-5, calc.sub(-3, 2));
        assertEquals(0, calc.sub(0, 0));
    }

    @Test
    public void testDiv() {
        Calc calc = new Calc();
        assertEquals(2, calc.div(6, 3));
        assertEquals(-2, calc.div(-6, 3));
        assertEquals(0, calc.div(0, 5));
    }

    @Test
    public void testMulti() {
        Calc calc = new Calc();
        assertEquals(6, calc.multi(2, 3));
        assertEquals(-6, calc.multi(-2, 3));
        assertEquals(0, calc.multi(0, 5));
    }
}