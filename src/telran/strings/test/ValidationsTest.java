package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.strings.Validations;

class ValidationsTest {

	@Test
		void testIsArithmeticExpression() {
			assertTrue(Validations.isArithmeticExpression("1"));
			assertTrue(Validations.isArithmeticExpression("  1  "));
			assertTrue(Validations.isArithmeticExpression("(1)"));
			assertTrue(Validations.isArithmeticExpression("12.3+abc"));
			assertTrue(Validations.isArithmeticExpression("(20.5+abc)*2"));
			assertTrue(Validations.isArithmeticExpression("(abc)"));
			
			assertFalse(Validations.isArithmeticExpression("(a + b)) * ((b + a)"));		
			
			assertFalse(Validations.isArithmeticExpression("2 +() 3"));
			assertFalse(Validations.isArithmeticExpression("(20.5 + abc12))*2"));
			assertFalse(Validations.isArithmeticExpression("(20.5+abc))*2"));
			assertFalse(Validations.isArithmeticExpression("2 + _"));
			assertFalse(Validations.isArithmeticExpression("2 + a12 * "));
			assertFalse(Validations.isArithmeticExpression("2 + )a12"));
			assertFalse(Validations.isArithmeticExpression(")20.5+abc / 3)"));
			assertFalse(Validations.isArithmeticExpression("20.5+abc / 3("));
			assertFalse(Validations.isArithmeticExpression("(  (20.5+abc / 3 ) "));
			assertFalse(Validations.isArithmeticExpression("  (20.5+abc / 3 ) )"));
			
		}

}
