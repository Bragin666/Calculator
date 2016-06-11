public class Calculator {
	private int param = 0;
	
	public void add(int... args) {
		for (int i : args) {
			param += i;
		}
	}

	public void subtrakt(int... args) {
		for (int i : args) {
			param -= i;
		}
	}

	public void multiply(int... args) {
		for (int i : args) {
			param *= i;
		}
	}

	public void divide(int... args) {
		for (int i : args) {
			param /= i;
		}
	}

	public void get() {
		System.out.println(param);
	}

	public void set(int i) {
		param = i;
	}

	public void clear() {
		param = 0;
	}
}