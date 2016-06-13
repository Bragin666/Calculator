package ru.calculator.mycalculator;

import ru.calculator.mycalculator.Interfaces.Operation;

import java.util.HashMap;
import java.util.Map;

/**
* ��������� �����������
*/
class Calculator {
	/** ��������� ���������� */
	private int result = 0;
	/** ����� ��������� �������� */
	private Map<String, Operation> operations = new HashMap<String, Operation>();

	/**
	 * �����������, ������������ ��� ��������� ��������
	 */
	Calculator() {
		this.load(new Adding());
		this.load(new Subtraction());
		this.load(new Multiplication());
		this.load(new Dividing());
	}

	/**
	 * ��������� ����� �������� ������������
	 */
	private void load (Operation operation) {
		this.operations.put(operation.getOperation(), operation);
	}

	/**
	 * ��������� ����������
	 * @param operation ������ ��������
	 * @param arg �������� ����������
     */
	void calculate(String operation, int arg) {
		this.result = operations.get(operation).doOperation(this.result, arg);
	}

	/**
	* ���������� ��������� ����������
	*/
	int getResult() {
		return result;
	}

	/**
	* ������ ��������� �������� ���������� ����������
	* @param i ������������� �������� ����������
	*/
	void setResult(int i) {
		result = i;
	}

	/**
	 * ��������� �������� ��������
	 */
	private static final class Adding implements Operation {

		/**
		 * ���������� ������ ��������
		 *
		 * @return ������ ��������
		 */
		public String getOperation() {
			return "+";
		}

		/**
		 * ��������� �������
		 *
		 * @param arg1 ������ ��������
		 * @param arg2 ������ ��������
		 * @return ��������� ����������
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 + arg2;
		}
	}

	/**
	 * ��������� �������� ���������
	 */
	private static final class Subtraction implements Operation {

		/**
		 * ���������� ������ ��������
		 *
		 * @return ������ ��������
		 */
		public String getOperation() {
			return "-";
		}

		/**
		 * ��������� ��������
		 *
		 * @param arg1 ������ ��������
		 * @param arg2 ������ ��������
		 * @return ��������� ����������
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 - arg2;
		}
	}

	/**
	 * ��������� �������� ���������
	 */
	private static final class Multiplication implements Operation {

		/**
		 * ���������� ������ ��������
		 *
		 * @return ������ ��������
		 */
		public String getOperation() {
			return "*";
		}

		/**
		 * ��������� ��������
		 *
		 * @param arg1 ������ ��������
		 * @param arg2 ������ ��������
		 * @return ��������� ����������
		 */
		public int doOperation(int arg1, int arg2) {
			return arg1 * arg2;
		}
	}

	/**
	 * ��������� �������� �������
	 */
	private static final class Dividing implements Operation {

		/**
		 * ���������� ������ ��������
		 *
		 * @return ������ ��������
		 */
		public String getOperation() {
			return "/";
		}

		/**
		 * ��������� �������
		 *
		 * @param arg1 ������ ��������
		 * @param arg2 ������ ��������
		 * @return ��������� ����������
		 */
		public int doOperation(int arg1, int arg2) {
			if (arg2 == 0) throw new ArithmeticException();
			return arg1 / arg2;
		}
	}
}
