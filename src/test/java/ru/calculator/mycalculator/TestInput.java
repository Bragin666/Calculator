package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Input;

/**
 * Реализует интерфейс Input для тестов
 * Created by Djony on 13.06.2016.
 */
class TestInput implements Input {
    /** Массив запросов */
    private String[] lines;
    /** Индекс текущего запроса */
    private int i = 0;

    /**
     * Пустой конструктор
     */
    TestInput() {
    }

    /**
     * Конструктор с массивом входных строк
     * @param lines Массив входных строк
     */
    TestInput(String[] lines) {
        this.lines = lines;
    }

    /**
     * Возвращает следующий запрос из массива запросов
     * @return Запрос
     */
    public String next() {
        return lines[i++];
    }

    /**
     * Заглушка
     * @param line Текст запроса
     */
    public void ask(String line) {

    }

    /**
     * Заглушка
     */
    public void close() {

    }
}
