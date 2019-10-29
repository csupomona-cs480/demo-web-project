package edu.csupomona.cs480.cal;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
		int res = c.add(10, 20);
		Assert.assertEquals(30, res);
	}
}
