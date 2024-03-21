package telran.strings;

public class Validations {
	public static boolean isArithmeticExpression(String expression) {
		//1. Checking against the regular expression
		//2. Checking brackets pairness For each '(' there should be ')"
		//consider introducing counter that increased for '(' and decreased for ')'
		//if during passing over the string expression counter < 0 returning false
		//if after passing whole string counter != 0 returning false
		
		String regex = RegularExpresions.arithmeticExpression();
		return expression.matches(regex) && areBracketsSymmetrical(expression);
	}
	private static boolean areBracketsSymmetrical(String expression) {
		int counter = 0;
		int index = 0;
		while(index < expression.length() && counter > -1) {
			char ch = expression.charAt(index++);
			if( ch == '(' ) counter++;
			if( ch == ')' ) counter--;
		}

		return counter==0; 
	}
	
}
