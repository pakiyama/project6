/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create a class to represent a Beverage Shop.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */
import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface{
	public ArrayList<Order> orders;
	
	public BevShop() {
		orders = new ArrayList<Order>();
	}
	public boolean isValidTime(int time) {
		if(time >= 8 && time <= 23) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	public boolean isEligibleForMore() {
		Order order = orders.get(orders.size()-1);
		int numOfAlcohol = order.findNumOfBeveType(Type.ALCOHOL);
	    return numOfAlcohol < getMaxOrderForAlcohol();
	}
	public int getNumOfAlcoholDrink() {
		Order order = orders.get(orders.size()-1);
		int numOfAlcohol = order.findNumOfBeveType(Type.ALCOHOL);
		return numOfAlcohol;
		
	}
	public boolean isValidAge(int age) {
		return age > MIN_AGE_FOR_ALCOHOL;
	}
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer cust = new Customer(customerName, customerAge);
		Order order = new Order(time, day, cust);
		orders.add(order);
	}
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size);
	}
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(orders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	public int findOrder(int orderNo) {
		for (int i = 0; i <= orders.size()-1; i++) {
	        if (orders.get(i).getOrderNo() == orderNo) {
	            return i;
	        }
	    }
	    return -1;
	}
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		if (index == -1) {
	        System.out.println("Order not found");
	        return -1;
		}
		Order order = orders.get(index);
		return order.calcOrderTotal();
	}
	public double totalMonthlySale() {
		double totalSale = 0.0;
		for(Order order : orders) {
			totalSale += order.calcOrderTotal();
		}
		return totalSale;
	}
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	public Order getCurrentOrder() {
		return orders.get(orders.size()-1);
	}
	public Order getOrderAtIndex(int index) {
		if(index >= 0 && index < orders.size()) {
			return orders.get(index);
		}
		else {
			return null;
		}
	}
	public void sortOrders() {
		int n = orders.size();
	    for (int i = 0; i < n - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
	                minIndex = j;
	            }
	        }
	        if (minIndex != i) {
	            Collections.swap(orders, i, minIndex);
	        }
	    }
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

	    for (Order order : orders) {
	        sb.append(order.toString());
	        sb.append("\n");
	    }
	    double totalSale = totalMonthlySale();
	    sb.append("Total monthly sale: $");
	    sb.append(String.format("%.2f", totalSale));
	    return sb.toString();
	}
}
