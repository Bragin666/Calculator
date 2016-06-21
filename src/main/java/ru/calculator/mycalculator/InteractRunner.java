package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Input;
import ru.calculator.mycalculator.Interfaces.Output;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Реализует интерактивную работу калькулятора
 */
public class InteractRunner {
	/** Входящий поток данных */
	private final Input input;
	/** Исходящий поток данных */
	private final Output output;
	/** Калькулятор */
	private final Calculator calculator;

	/**
	 * Мэйн
	 * @param args
     */
	public static void main(String... args){
		RealOutput realOutput = new RealOutput();
		InteractRunner runner = new InteractRunner(new RealInput(realOutput), realOutput, new Calculator());
		runner.action();
		runner.getInput().close();
	}

	/**
	 * Основной конструктор класса
	 * @param input Входной поток данных
	 * @param output Выходной поток данных
	 * @param calculator Калькулятор
     */
	InteractRunner(Input input, Output output, Calculator calculator) {
		this.input = input;
		this.output = output;
		this.calculator = calculator;
	}

	/**
	 * Запускает интерактивный калькулятор
	 */
	void action() {
		input.ask("Calculator turn on.\nc - clear\nq - exit\n" +
				"Enter first argument or operation :");
		try {
			String s;
			while (true){
				s = input.next();
				// Арифметическая операция
				if (isOperation(s)) {
					input.ask("Enter next argument");
					int arg = nextNumber();
					calculator.calculate(s, arg);
					input.ask("Enter next operation");
				}
				// Вывод результата
				else if  (s.equals("=")) {
					output.print(calculator.getResult() + "");
					input.ask("Enter next operation or number");
				}
				// Зануление результата
				else if  (s.equals("c")) {
					calculator.setResult(0);
					input.ask("Enter next argument");
				}
				// Изменение первого аргумента в операции
				else if (isNumber(s)) {
					calculator.setResult(Integer.valueOf(s));
					input.ask("Enter next operation");
				}
				// Ошибка ввода
				else output.print("Wrong enter! Try again:");
			}

		}
		catch (Exception e) { System.out.println("Exception! Calculator turn off"); }
	}

	/**
	 * Возвращает поток ввода, что бы можно было его закрыть
	 * @return Поток ввода данных
     */
	private Input getInput() {
		return input;
	}

	/**
	 * Проверяет является ли строчка простым числом
	 * @param line Проверяемая строка
	 * @return Да или Нет
     */
	boolean isNumber(String line){
		Pattern p = Pattern.compile("^-?\\d+$");
		Matcher m = p.matcher(line);
		return m.matches();
	}

	/**
	 * Проверяет является ли строчка арифметической операцией
	 * @param line Проверяемая строка
	 * @return Да или Нет
	 */
	boolean isOperation(String line){
		Pattern p = Pattern.compile("^\\*|/|\\+|-{1}$");
		Matcher m = p.matcher(line);
		return m.matches();
	}

	/**
	 * Дожидидается ввода валидного числа и возвращает его
	 * @return Валидное число
     */
	int nextNumber() {
		int i;
		while (true) {
			String s = input.next();
			if (isNumber(s)) {
				i = Integer.valueOf(s);
				break;
			}
			else input.ask("Wrong enter! It isn't a number. Try again :");
		}
		return i;
	}


}