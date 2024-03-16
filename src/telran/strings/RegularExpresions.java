package telran.strings;

public class RegularExpresions {
	public static String javaVariable() {  
		String regex="[A-Za-z$][\\w$]*|_[\\w]+";
		return regex;
	}
public static String zero_300 () {
	//string contains number from 0 -300 ;leading zeros are disallowed
	String regex ="[1-9]\\d?|[1-2]\\d\\d|300|0";
	return regex;
}
public static String ipOctet() {
	String regex ="25[0-5]|2[0-4][0-9]|[01]?\\d{1,2}|0|00|000";
	return regex;
}
public static String mobileIsraelPhone() {
	String regex ="(\\+972(5[0-9])|05[0-9])[ -]?(\\d{3})[ -]?(\\d{2})[ -]?(\\d{2})";
	return regex;
}

}
