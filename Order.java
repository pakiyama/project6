/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create a class to represent an order.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */
import java.util.Random;
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order>{
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.beverages = new ArrayList<>();
		this.orderNumber = generateOrder();
	}
	public int generateOrder() {
		Random random = new Random();
		orderNumber = random.nextInt(80001) + 10000;
		return orderNumber;
	}
	public int getOrderNo() {
		return orderNumber;
	}
	public int getOrderTime() {
		return orderTime;
	}
	public Day getOrderDay() {
		return orderDay;
	}
	public Customer getCustomer() {
		return new Customer(cust.getName(), cust.getAge());
	}
	public Day getDay() {
		return orderDay;
	}
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	public Beverage getBeverage(int itemNo) {
		if(itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}
		else {
			return null;
		}
	}
	public int getTotalItems() {
		return beverages.size();
	}
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage newBeverage = new Coffee(bevName, size, extraShot, extraSyrup);
	    beverages.add(newBeverage);
	}
	public void addNewBeverage(String bevName, Size size) {
		boolean weekend = isWeekend();
		Beverage newBeverage = new Alcohol(bevName, size, weekend);
	    beverages.add(newBeverage);
	}
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage newBeverage = new Smoothie(bevName, size, numOfFruits, addProtein);
	    beverages.add(newBeverage);
	}
	public double calcOrderTotal() {
		double total = 0.0;
		for (Beverage bev : beverages) {
			total += bev.calcPrice();
		}
	    return total;
	}
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for (Beverage bev : beverages) {
			if(bev.getType() == type) {
				count++;
			}
		}
		return count;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order #").append(orderNumber).append("\n");
	    sb.append("Order time: ").append(orderTime).append(":00").append("\n");
	    sb.append("Order day: ").append(orderDay).append("\n");
	    sb.append("Customer: ").append(cust.getName()).append(", ").append(cust.getAge()).append("\n");
	    sb.append("Beverages:").append("\n");
	    for (int i = 0; i < beverages.size(); i++) {
	    	sb.append(i+1).append(". ").append(beverages.get(i).toString()).append("\n");
	    }
	    sb.append("Total: $").append(String.format("%.2f", calcOrderTotal()));
	    return sb.toString();
	}
	@Override
	public int compareTo(Order anotherOrder) {
		if(this.orderNumber == anotherOrder.orderNumber) {
			return 0;
		}
		else if (this.orderNumber > anotherOrder.orderNumber) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
