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

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {
	Order orderOne, orderTwo, orderThree, orderFour;
	BevShop bevShop = new BevShop();
	@Before
	public void setUp() throws Exception {
		bevShop.startNewOrder(8, Day.MONDAY, "Mary", 22);
	}

	@After
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testFindOrders() {
		bevShop.processCoffeeOrder("regular Coffee", Size.SMALL, false, false);
		int orderNumber = bevShop.getCurrentOrder().getOrderNo();
		int index = bevShop.findOrder(orderNumber);
		assertEquals(0,index);
	}
	@Test
	public void testTotalOrderPrice() {
		bevShop.processCoffeeOrder("regular Coffee", Size.SMALL, false, false);
		int orderNumber = bevShop.getCurrentOrder().getOrderNo();
		double price = bevShop.totalOrderPrice(orderNumber);
		assertEquals(2.0,price,.01);
	}
}
