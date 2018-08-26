package rentalstore;

/**
 * Created by Vito Zhuang on 8/24/2018.
 */
public abstract class MovieType {
	public abstract double getAmount(int dayRented);
	public double updateFrequentRenterPoints(double frequentRenterPoints, Rental each) {
		return ++frequentRenterPoints;
	}
}
