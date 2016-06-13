package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Operation;

import java.util.HashMap;
import java.util.Map;

/**
* Реализует калькулятор
*/
class Calculator {
	/** Результат вычисления */
	private int result = 0;
	/** Набор доступных операций */
	private Map<String, Operation> operations = new HashMap<String, Operation>();

	/**
	 * Конструктор, подгружающий все доступные операции
	 */
	Calculator() {
		this.load(new Adding());
		this.load(new Subtraction());
		this.load(new Multiplication());
		this.load(new Dividing());
	}

	/**
	 * Добавляет новую операцию калькулятору
	 */
	private void load (Operation operation) {
		this.operations.put(operation.getOperation(), operation);
	}

	/**
	 * Выполняет вычисления
	 * @param operation Символ операции
	 * @param arg Аргумент вычисления
     */
	void calculate(String operation, int arg) {
		this.result = operations.get(operation).doOperation(this.result, arg);
	}

	/**
	* Возвращает результат вычисления
	*/
	int getResult() {
		return result;
	}

	/**
	* Задает начальное значение результату вычисления
	* @param i Присваеваемое значение результата
	*/
	void setResult(int i) {
		result = i;
	}

	/**
	 * Реализует операцию сложения
	 */
	private static final class Adding implements Operation {

		/**
		 * Возвращает символ операции
		 *
		 * @return Символ опреации
		 */
		public String getOperation() {
			return "+";
		}

		/**
		 * Выполняет опрецию
		 *
		 * @param arg1 Первый аргумент
		 * @param arg2 Второй аргумент
		 * @return Результат вычисления
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 + arg2;
		}
	}

	/**
	 * Реализует операцию вычитания
	 */
	private static final class Subtraction implements Operation {

		/**
		 * Возвращает символ операции
		 *
		 * @return Символ опреации
		 */
		public String getOperation() {
			return "-";
		}

		/**
		 * Выполняет операцию
		 *
		 * @param arg1 Первый аргумент
		 * @param arg2 Второй аргумент
		 * @return Результат вычисления
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 - arg2;
		}
	}

	/**
	 * Реализует операцию умножения
	 */
	private static final class Multiplication implements Operation {

		/**
		 * Возвращает символ операции
		 *
		 * @return Символ опреации
		 */
		public String getOperation() {
			return "*";
		}

		/**
		 * Выполняет операцию
		 *
		 * @param arg1 Первый аргумент
		 * @param arg2 Второй аргумент
		 * @return Результат вычисления
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 * arg2;
		}
	}

	/**
	 * Реализует операцию деления
	 */
	private static final class Dividing implements Operation {

		/**
		 * Возвращает символ операции
		 *
		 * @return Символ опреации
		 */
		public String getOperation() {
			return "/";
		}

		/**
		 * Выполняет опрецию
		 *
		 * @param arg1 Первый аргумент
		 * @param arg2 Второй аргумент
		 * @return Результат вычисления
		 */
		public int doOperation(int arg1, int arg2) {
			if (arg2 == 0) throw new ArithmeticException();
			return arg1 / arg2;
		}
	}
}
