package ru.calculator.mycalculator.Interfaces;

/**
* ��������� ����� ������
*/
public interface Input {

	/**
	* ��������� ����� ������
	*/
	String next();

	/**
	 * ������ �� ���� ������
	 * @param line ����� �������
	 */
	void ask(String line);

	/**
	 * ��������� ����� ����� ������
	 */
	void close();

}