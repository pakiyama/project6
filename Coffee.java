/*
 * Class: CMSC203 CRN 31648
 * Instructor: Gary Thai
 * Description: Create subclass of Beverage called Coffee.
 * Due: 05/05/2023
 * Platform/compiler: Eclipse IDE/JDK
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your name here: Paul Akiyama
 */

public class Coffee extends Beverage {
	private final boolean extraShot;
	private final boolean extraSyrup;
	private static final double EXTRA_PRICE = 0.5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
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
		if(extraShot) {
			price += EXTRA_PRICE;
		}
		if(extraSyrup) {
			price += EXTRA_PRICE;
		}
		return price;
	}
	@Override
	public String toString() {
		String priceStr = String.format("$%.2f", calcPrice());
		return super.toString() + ", " + extraShot + ", " + extraSyrup + ", " + priceStr;
	}
	@Override
	public boolean equals(Object anotherBev) {
		if(!super.equals(anotherBev)) {
			return false;
		}
		Coffee tempBev = (Coffee) anotherBev;
		if((this.extraShot == tempBev.extraShot) && (this.extraSyrup == tempBev.extraSyrup)) {
			return true;
		}
		else {
			return false;
		}
	}
}
