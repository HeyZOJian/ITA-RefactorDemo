package rentalstore;

/**
 * Created by Vito Zhuang on 8/24/2018.
 */
public class NewRelease extends MovieType {
	public double getAmount(int dayRented) {
		return dayRented * 3;
	}

	@Override
	public double updateFrequentRenterPoints(double frequentRenterPoints, Rental each) {
		frequentRenterPoints++;
		if (each.getDayRented() > 1){
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
}
