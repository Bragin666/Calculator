package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Input;
import ru.calculator.mycalculator.Interfaces.Output;

import java.util.Scanner;

/**
 * Реализуют интерфейс Input при помощи Scanner
 * Created by Djony on 13.06.2016.
 */
class RealInput implements Input {
    /** Сканер для считывания данных из консоли */
    private Scanner scanner = new Scanner(System.in);
    /** Поток вывода */
    private Output output;

    /**
     * Конструктор с потоком ввода данных
     * @param output Поток ввода данных
     */
    RealInput(Output output) {
        this.output = output;
    }

    /**
     * Считывает строку с консоли
     * @return Считанная строка
     */
    public String next() {
        String s = scanner.next();
        if (s.equals("q")) {
            output.print("Calculator turn off");
            System.exit(0);
        }
        return s;
    }

    /**
     * Запрос на ввод данных
     * @param line Текст запроса
     */
    public void ask(String line) {
        output.print(line);
    }

    /**
     * Закрывает сканер
     */
    public void close() {
        scanner.close();
    }
}
