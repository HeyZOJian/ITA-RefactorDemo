package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public class TxtStatement implements Statement {
	private Vector rentals;
	private String name;

	public TxtStatement(Vector rental, String name) {
		this.rentals = rental;
		this.name = name;
	}

	public String getValue() {
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

	public int updateFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints++;
		//add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRented() > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
	public String footerString(double totalAmount, int frequentRenterPoints) {
		return "Amount owed is " + String.valueOf(totalAmount) + "\n"
				+ "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
	}

	public String eachRentalString(double thisAmount, Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
	}

	public String headerString() {
		return "Recordntal Record for " + this.name + "\n";
	}
}
