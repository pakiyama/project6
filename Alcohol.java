/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create subclass of Beverage called Alcohol.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

public class Alcohol extends Beverage {
	private final boolean isWeekend;
	private static double WEEKEND_PRICE = 0.6;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	public boolean isWeekend() {
		return isWeekend;
	}
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		if(super.getSize() == Size.MEDIUM) {
			price += super.addSizePrice();
		}
		else if(super.getSize() == Size.LARGE) {
			price += super.addSizePrice() + super.addSizePrice();
		}
		if(isWeekend) {
			price += WEEKEND_PRICE;
		}
		return price;
	}
	@Override
	public String toString() {
		String priceStr = String.format("$%.2f", calcPrice());
		return super.toString() + ", " + isWeekend + ", " + priceStr;
	}
	@Override
	public boolean equals(Object anotherBev) {
		if(!super.equals(anotherBev)) {
			return false;
		}
		Alcohol tempBev = (Alcohol) anotherBev;
		if(this.isWeekend == tempBev.isWeekend) {
			return true;
		}
		else {
			return false;
		}
	}
}
