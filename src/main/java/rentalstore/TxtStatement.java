package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public class TxtStatement extends Statement {

	public TxtStatement(Vector rental, String name) {
		super.rentals = rental;
		super.name = name;
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
