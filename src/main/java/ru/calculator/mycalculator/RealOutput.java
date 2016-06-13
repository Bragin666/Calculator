package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Output;

/**
 * Реализует интерфейс Output выводом данных в консоль
 * Created by Djony on 13.06.2016.
 */
public class RealOutput implements Output {
    /**
     * Выводит данные в консоль
     * @param line Строка для вывода
     */
    public void print(String line) {
        System.out.println(line);
    }
}
