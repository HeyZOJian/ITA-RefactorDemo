package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String name;
	private Vector rentals = new Vector();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = this.rentals.elements();
		// header
		StringBuilder result = new StringBuilder(headerString());
		// content
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount += each.getAmount();
			//add frequent renter points
			frequentRenterPoints = updateFrequentRenterPoints(frequentRenterPoints, each);
			//show figures for this rental
			result.append(eachRentalString(thisAmount, each));
			totalAmount += thisAmount;
		}
		//footer
		result.append(footerString(totalAmount, frequentRenterPoints));

		return result.toString();
	}

	private int updateFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints++;
		//add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

	private String footerString(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n"
		+ "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
	}

	private String eachRentalString(double thisAmount, Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
	}

	private String headerString() {
		return "Recordntal Record for " + getName() + "\n";
	}
}
