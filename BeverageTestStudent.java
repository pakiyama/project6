/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: JUnit Test Case
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeverageTestStudent {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBasePrice() {
		Beverage coffee = new Coffee("bevName", Size.MEDIUM, true, false);
		double basePrice = coffee.getBasePrice();
		assertEquals(2.0, basePrice, 0.01);
	}
	@Test
	public void testAddSizePrice() {
		Beverage coffee = new Coffee("bevName", Size.MEDIUM, true, false);
		double sizePrice = coffee.addSizePrice();
		assertEquals(1.0, sizePrice, 0.01);
	}
}
