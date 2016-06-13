package ru.calculator.mycalculator;

import org.junit.Test;
import ru.calculator.mycalculator.Interfaces.Input;
import ru.calculator.mycalculator.Interfaces.Output;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тестирует класс InteractRunner
 * Created by Djony on 13.06.2016.
 */
public class InteractRunnerTest {

    /**
     * Тестирует метод action на правильность посчета
     * @throws Exception
     */
    @Test
    public void calculate() throws Exception {
        Output output = new TestOutput();
        String[] lines = {"1", "+", "2", "*", "4", "/", "3", "="};
        Input input = new TestInput(lines);
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        runner.action();

        assertThat(((TestOutput) output).getLine(), is("4"));
    }

    /**
     * Тестирует метод action на обнуление результата
     * @throws Exception
     */
    @Test
    public void clear() throws Exception {
        Output output = new TestOutput();
        String[] lines = {"1", "+", "2", "с", "4", "/", "2", "="};
        Input input = new TestInput(lines);
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        runner.action();

        assertThat(((TestOutput) output).getLine(), is("2"));
    }

    /**
     * Тестирует метод action на некорректный ввод
     * @throws Exception
     */
    @Test
    public void wrongEnter() throws Exception {
        Output output = new TestOutput();
        String[] lines = {"1", "+", "a", "2", "h", "*", "3", "="};
        Input input = new TestInput(lines);
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        runner.action();

        assertThat(((TestOutput) output).getLine(), is("9"));
    }

    /**
     * Тест метода isNumber
     * @throws Exception
     */
    @Test
    public void isNumber() throws Exception {
        Output output = new TestOutput();
        Input input = new TestInput();
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        assertThat(runner.isNumber("1"), is(true));
        assertThat(runner.isNumber("23"), is(true));
        assertThat(runner.isNumber("-23"), is(true));
        assertThat(runner.isNumber("--123"), is(false));
        assertThat(runner.isNumber("123-"), is(false));
        assertThat(runner.isNumber("12-3"), is(false));
    }

    /**
     * Тест метода isOperation
     * @throws Exception
     */
    @Test
    public void isOperation() throws Exception {
        Output output = new TestOutput();
        Input input = new TestInput();
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        assertThat(runner.isOperation("+"), is(true));
        assertThat(runner.isOperation("-"), is(true));
        assertThat(runner.isOperation("*"), is(true));
        assertThat(runner.isOperation("/"), is(true));
        assertThat(runner.isOperation("a"), is(false));
    }

    /**
     * Тест метода nextNumber
     * @throws Exception
     */
    @Test
    public void nextNumber() throws Exception {
        Output output = new TestOutput();
        String[] lines = {"+", "a", "-", "2", "=", "5"};
        Input input = new TestInput(lines);
        Calculator calculator = new Calculator();
        InteractRunner runner = new InteractRunner(input, output, calculator);

        int i = runner.nextNumber();

        assertThat(i, is(2));
    }

}