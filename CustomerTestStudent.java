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

public class CustomerTestStudent {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAge() {
		Customer cust = new Customer("Paul", 17);
		assertEquals(17,cust.getAge(), 0.01);
	}
	@Test
	public void testGetName() {
		Customer cust = new Customer("Paul", 17);
		assertEquals("Paul",cust.getName());	}
}
