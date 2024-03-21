package telran.strings;

public class RegularExpresions {
	public static String javaVariable() {
		String regex = "([A-Za-z$][\\w$]*|_[\\w]+)";
		return regex;
	}

	public static String zero_300() {
		// string contains number from 0 -300 ;leading zeros are disallowed
		String regex = "([1-9]\\d?|[1-2]\\d\\d|300|0)";
		return regex;
	}

	public static String ipOctet() {
		String regex = "(25[0-5]|2[0-4][0-9]|[01]?\\d{1,2}|0{1,3})";
		return regex;
	}

	public static String mobileIsraelPhone() {
		String regex = "(\\+972(5[0-9])|05[0-9])[ -]?(\\d{3})[ -]?(\\d{2})[ -]?(\\d{2})";
		return regex;
	}

	public static String ipV4Address() {
		String ipOctetExpr = ipOctet();
		return String.format("%1$s(\\.%1$s){3}", ipOctetExpr);
	}

	public static String simpleAritmeticExpression() {
		String opreand = integerNumberExp();
		String operation = operationExp();
		return String.format("%1$s(%2$s%1$s)*", opreand, operation);
	}

	private static String integerNumberExp() {
		return "(\\s*\\d+\\s*)";
	}

	private static String operationExp() {
		return "[-+*/]";
	}
//HW
	public static String arithmeticExpression() {
		//operand - any number or Java variable name
		//operation - the same as for simpleArithmeticExpression
		//brackets '(' ')' are allowed
		String operand = operand();
		String operation = operationExp();
		return String.format("%1$s(%2$s%1$s)*", operand, operation);
	}
	private static String operand() {
		return "(" + bracketOpened() + "(" + javaVariable() + "|" + numericOperand() +")"
				+ bracketClosed() + ")";
	}
	//operand - any number or Java variable name
	private static String numericOperand() {
		return "(\\d+(\\.(\\d)+)*)";
	}
	//brackets '(' ')' are allowed
	private static String bracketOpened() {
		return "(\\s*\\(*\\s*)";
	}
	//brackets '(' ')' are allowed
	private static String bracketClosed() {
		return "(\\s*\\)*\\s*)";
	}
}
