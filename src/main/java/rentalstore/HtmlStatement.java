package rentalstore;

import java.util.Vector;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public class HtmlStatement extends Statement {

	public HtmlStatement(Vector rental, String name) {
		super.rentals = rental;
		super.name = name;
	}

	public String footerString(double totalAmount, double frequentRenterPoints) {
		return "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n"
				+ "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
	}

	public String eachRentalString(double thisAmount, Rental each) {
		return each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
	}

	public String headerString() {
		return "<H1>Rentals for <EM>" + this.name + "</EM></H1><P>\n";
	}
}
