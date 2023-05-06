/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create subclass of Beverage called Smoothie.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

public class Smoothie extends Beverage {
	private final int numOfFruits;
	private final boolean addProtein;
	private static final double FRUIT_PRICE = 0.5;
	private static final double PROTEIN_PRICE = 1.5;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getAddProtein() {
		return addProtein;
	}
	@Override
	public String toString() {
		String priceStr = String.format("$%.2f", calcPrice());
		return super.toString() + ", " + addProtein + ", " + numOfFruits + ", " + priceStr;
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
		for(int i = 0; i < numOfFruits; i++) {
			price += FRUIT_PRICE;
		}
		if(addProtein) {
			price += PROTEIN_PRICE;
		}
		return price;
	}
	@Override
	public boolean equals(Object anotherBev) {
		if(!super.equals(anotherBev)) {
			return false;
		}
		Smoothie tempBev = (Smoothie) anotherBev;
		if((this.numOfFruits == tempBev.numOfFruits) && (this.addProtein == tempBev.addProtein)) {
			return true;
		}
		else {
			return false;
		}
	}
}
