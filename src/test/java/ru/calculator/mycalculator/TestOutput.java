package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Output;

/**
 * Реализует интерфейс Output для тестов
 * Created by Djony on 13.06.2016.
 */
class TestOutput implements Output {
    /** Выводимая строка */
    private String line;

    /**
     * Подменяет вывод строки ее сохранением.
     * Но если выводится сообщение об ошибке (длинная сторока),
     * то сохранение не происходит
     */
    public void print(String line) {
        if (line.length() < 10) this.line = line;
    }

    /** Возвращает выводимую строку */
    String getLine() {
        return line;
    }
}
