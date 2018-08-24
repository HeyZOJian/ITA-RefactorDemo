package rentalstore;

/**
 * Created by Vito Zhuang on 8/24/2018.
 */
public class NewRelease implements MovieType {
	public double getAmount(int dayRented) {
		return dayRented * 3;

	}
}
