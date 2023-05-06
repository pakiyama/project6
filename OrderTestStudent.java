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

public class OrderTestStudent {
	Order orderOne, orderTwo, orderThree, orderFour;
	@Before
	public void setUp() throws Exception {
		orderOne = new Order(8, Day.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, Day.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, Day.SUNDAY, new Customer("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testGetTotalItems() {
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("Mohito", Size.SMALL);
		orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);
		
		assertEquals(3,orderOne.getTotalItems());
	}
	@Test
	public void testFindNumOfBeveType() {
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
		
		assertEquals(4,orderOne.findNumOfBeveType(Type.COFFEE));
	}
}
