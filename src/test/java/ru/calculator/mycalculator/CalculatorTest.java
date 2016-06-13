package ru.calculator.mycalculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Тест класса Calculator
 * Created by Djony on 13.06.2016.
 */
public class CalculatorTest {
    /**
     * Тест операции сложения
     * @throws Exception
     */
    @Test
    public void adding() throws Exception {
        Calculator calculator = new Calculator();

        calculator.calculate("+", 2);
        calculator.calculate("+", 4);

        assertThat(calculator.getResult(), is(6));
    }

    /**
     * Тест операции вычитания
     * @throws Exception
     */
    @Test
    public void subtraction() throws Exception {
        Calculator calculator = new Calculator();

        calculator.calculate("-", 2);
        calculator.calculate("-", 4);

        assertThat(calculator.getResult(), is(-6));
    }

    /**
     * Тест операции умножения
     * @throws Exception
     */
    @Test
    public void multiplication() throws Exception {
        Calculator calculator = new Calculator();

        calculator.calculate("+", 2);
        calculator.calculate("*", 4);

        assertThat(calculator.getResult(), is(8));
    }

    /**
     * Тест операции деление
     * @throws Exception
     */
    @Test
    public void dividing() throws Exception {
        Calculator calculator = new Calculator();

        calculator.calculate("+", 4);
        calculator.calculate("/", 2);

        assertThat(calculator.getResult(), is(2));
    }

    /**
     * Тест на деление на ноль
     * @throws Exception
     */
    @Test(expected = ArithmeticException.class)
    public void arithmeticException() throws Exception {
        Calculator calculator = new Calculator();

        calculator.calculate("/", 0);
    }
}