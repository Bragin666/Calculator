import java.util.Scanner;

public class InteractRunner {

	public static void main(String... args){
		System.out.println("Calculator turn on");
		Calculator calculator = new Calculator();
		try (Scanner scanner = new Scanner(System.in)) {
			String s;
			outer: while (true){
				switch (s = scanner.next()) {
					case "+" : calculator.add(Integer.valueOf(scanner.next()));
						   break;
					case "-" : calculator.subtrakt(Integer.valueOf(scanner.next()));
						   break;
					case "*" : calculator.multiply(Integer.valueOf(scanner.next()));
						   break;
					case "/" : calculator.divide(Integer.valueOf(scanner.next()));
						   break;
					case "=" : calculator.get();
						   break;
					case "c" : calculator.clear();
						   break;
					case "q" : break outer;
					default  : calculator.set(Integer.valueOf(s));
						   break;
				}
			}
			System.out.println("Calculator turn off");
		}
		catch (Exception e) { System.out.println("Exceptin!"); }
	};

}