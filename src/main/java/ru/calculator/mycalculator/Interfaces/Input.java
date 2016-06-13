package ru.calculator.mycalculator.Interfaces;

/**
* Интерфейс ввода данных
*/
public interface Input {

	/**
	* Считывает новую строку
	*/
	String next();

	/**
	 * Запрос на ввод данных
	 * @param line Текст запроса
	 */
	void ask(String line);

	/**
	 * Закрывает поток ввода данных
	 */
	void close();

}