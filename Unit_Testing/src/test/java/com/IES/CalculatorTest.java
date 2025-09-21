package com.IES;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator cal;
	
	@BeforeEach
	public void calci() {
		cal = new Calculator();
	}
	
	@AfterEach
	public void deleteCalciObject() {
		cal = new Calculator();
	}
	
	@Test
	public void testAddFunction() {
		int result=cal.add(100, 200);
		
		assertEquals(200, result);
	}

	@Test
	public void testSubFunction() {
		int result=cal.sub(200, 100);
		
		assertEquals(100, result);
	}
}
