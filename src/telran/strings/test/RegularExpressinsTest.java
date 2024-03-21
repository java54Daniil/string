package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import telran.strings.RegularExpresions;

class RegularExpressinsTest {

	@Test
	void javVariableTrueTets() {
		String regex= RegularExpresions.javaVariable();
		assertTrue("abs".matches(regex));
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex));
		assertTrue("$123".matches(regex));
		assertTrue("$1_23".matches(regex));
		assertTrue("abc_".matches(regex));
		assertTrue("__".matches(regex));
		assertTrue("Abc_".matches(regex));
	}
	@Test
	void javVariableFalseTets() {
		String regex= RegularExpresions.javaVariable();
		assertFalse("1abc".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a-2".matches(regex));
		assertFalse("a 2".matches(regex));
		assertFalse("a?2".matches(regex));
		assertFalse("i*nt".matches(regex));
	}
	@Test 
	void zero_300TrueTest() {
		String regex= RegularExpresions.zero_300();
		assertTrue("0".matches(regex));
		assertTrue("1".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("30".matches(regex));
		assertTrue("33".matches(regex));
		assertTrue("198".matches(regex));
		assertTrue("299".matches(regex));
		assertTrue("300".matches(regex));
	}
	void zero_300TFalseTest() {
		String regex= RegularExpresions.zero_300();
		assertFalse("00".matches(regex));
		assertFalse("01".matches(regex));
		assertFalse("19s".matches(regex));
		assertFalse("-30".matches(regex));
		assertFalse("330".matches(regex));
		assertFalse("398".matches(regex));
		assertFalse("2990".matches(regex));
		assertFalse("301".matches(regex));
	}
	@Test 
	void ipOctetTest() {
		String regex= RegularExpresions.ipOctet();
		assertTrue("0".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("000".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("009".matches(regex));
		assertTrue("255".matches(regex));
		assertTrue("250".matches(regex));
		assertTrue("249".matches(regex));
		assertTrue("7".matches(regex));
		assertFalse("-0".matches(regex));
		assertFalse("00 ".matches(regex));
		assertFalse("0000".matches(regex));
		assertFalse("10?".matches(regex));
		assertFalse("1900".matches(regex));
		assertFalse("299".matches(regex));
		assertFalse("00a".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("260".matches(regex));
		assertFalse("300".matches(regex));
	}
	@Test
	void mobileIsraelPhoneTest() {
		String regex= RegularExpresions.mobileIsraelPhone();
		assertTrue("0547334458".matches(regex));
		assertTrue("054-733-44-58".matches(regex));
		assertTrue("+972501234567".matches(regex));
		assertTrue("+97250 123 45 67".matches(regex));
		assertTrue("0547334458".matches(regex));
		assertTrue("054 733 44 58".matches(regex));
		assertFalse("1234567890".matches(regex));
		assertFalse("+972012345678".matches(regex));
		assertFalse("05 4 733 44 58".matches(regex));
		assertFalse("05473344582".matches(regex));
		assertFalse("+9720123456789".matches(regex));
		assertFalse("05412345".matches(regex));
	}
	@Test 
	@DisplayName("test for IP v4 address regular expression")
	void ipV4AddressTest() {
		String ipV4Regex = RegularExpresions.ipV4Address();
		assertTrue("1.2.3.4".matches(ipV4Regex));
		assertFalse("1.2.3".matches(ipV4Regex));
		assertFalse("1 2.3.4".matches(ipV4Regex));
		assertFalse("1. 2.3.4".matches(ipV4Regex));
		assertFalse("1.2.3.4.5".matches(ipV4Regex));
		assertFalse("1.2.3&4".matches(ipV4Regex));
	}
@Test 
@DisplayName("test of simple aritmethic expression")
void simpleAritmeticExpressinsTest() {
	String regex = RegularExpresions.simpleAritmeticExpression();
	assertTrue("20".matches(regex));
	assertTrue("20 +3 /2 *100".matches(regex));
	assertTrue("10000-1".matches(regex));
	assertTrue("10000-1 ".matches(regex));
	assertFalse("-20".matches(regex));
	assertFalse("20 ** 3".matches(regex));
	assertFalse(" 20 +3 /2 *100 +".matches(regex));
	assertFalse("20 +3 //2 *100 +".matches(regex));
}
@Test
@DisplayName("test araritmethic expressions with any numbers or variable names and brackets")
void aritmethicExpressionTest() {
	//a=-a
	String regex = RegularExpresions.arithmeticExpression();
	assertTrue("(20.5 + abc)*2".matches(regex));
	assertTrue("(20.5 + abc12))*2".matches(regex));
	assertTrue("(20.5 + (abc$ /3)*(2".matches(regex));
	assertTrue("(abc)".matches(regex));
	assertFalse("__".matches(regex));
	assertFalse("2 + _".matches(regex));
	assertFalse("2 + a12 * ".matches(regex));
	assertFalse("(2 + )a12 * ".matches(regex));
}
}
