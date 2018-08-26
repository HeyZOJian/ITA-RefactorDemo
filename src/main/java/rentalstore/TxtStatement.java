package rentalstore;

import java.util.Vector;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public class TxtStatement extends Statement {

	public TxtStatement(Vector rental, String name) {
		super.rentals = rental;
		super.name = name;
	}

	public String footerString(double totalAmount, double frequentRenterPoints) {
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
