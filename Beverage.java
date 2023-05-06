/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create an abstract class called Beverage.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

public abstract class Beverage {
	private final String bevName;
	private final Type type;
	private final Size size;
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = 1.0;
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public Type getType() {
		return type;
	}
	public String getBevName() {
		return bevName;
	}
	public Size getSize() {
		return size;
	}
	public double addSizePrice() {
		return SIZE_PRICE;
	}
	@Override
	public String toString() {
		return bevName + ", " + size;
	}
	@Override
	public boolean equals(Object anotherBev) {
		if(!(anotherBev instanceof Beverage)) {
			return false;
		}
		Beverage tempBev = (Beverage) anotherBev;
		if((this.bevName == tempBev.bevName) && (this.type == tempBev.type) && (this.size == tempBev.size)) {
			return true;
		}
		else {
			return false;
		}
	}
	public abstract double calcPrice();
}
