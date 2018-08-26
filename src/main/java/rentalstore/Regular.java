package rentalstore;

/**
 * Created by Vito Zhuang on 8/24/2018.
 */
public class Regular extends MovieType {
	public double getAmount(int dayRented) {
		double thisAmount = 2;
		if (dayRented > 2) {
			thisAmount += (dayRented - 2) * 1.5;
		}
		return thisAmount;
	}
}
