package rentalstore;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public interface Statement {
	public String getValue();
	public int updateFrequentRenterPoints(int frequentRenterPoints, Rental each);
	public String headerString();
	public String eachRentalString(double thisAmount, Rental each);
	public String footerString(double totalAmount, int frequentRenterPoints);
}
