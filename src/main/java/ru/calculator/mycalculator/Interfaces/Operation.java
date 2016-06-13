package ru.calculator.mycalculator.Interfaces;

/**
 * Интерфейс Арефметическая операция
 * Created by Djony on 13.06.2016.
 */
public interface Operation {
    /**
     * Возвращает символ операции
     * @return Символ опреации
     */
    String getOperation();

    /**
     * Выполняет операцию
     * @param arg1 Первый аргумент
     * @param arg2 Второй аргумент
     * @return Резултат вычисления
     */
    int doOperation(int arg1, int arg2);
}
