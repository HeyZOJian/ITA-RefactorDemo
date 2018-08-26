package rentalstore;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public abstract class Statement {
	public Vector rentals;
	public String name;

	public String getValue(){
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
	};
	public abstract int updateFrequentRenterPoints(int frequentRenterPoints, Rental each);
	public abstract String headerString();
	public abstract String eachRentalString(double thisAmount, Rental each);
	public abstract String footerString(double totalAmount, int frequentRenterPoints);
}
