package rentalstore;

/**
 * Created by Vito Zhuang on 8/26/2018.
 */
public class Literary extends MovieType {
	public double getAmount(int dayRented) {
		return dayRented * 6;
	}

	public double updateFrequentRenterPoints(double frequentRenterPoints, Rental each) {
		return frequentRenterPoints+1.5;
	}
}
