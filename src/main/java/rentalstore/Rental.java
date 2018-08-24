package rentalstore;

public class Rental {
	private Movie movie;
	private int dayRented;
	private MovieType movieType;

	public Rental(Movie movie, int dayRented, MovieType movieType) {
		this.movie = movie;
		this.dayRented = dayRented;
		this.movieType = movieType;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDayRented() {
		return dayRented;
	}

	public double getAmount() {
		return movieType.getAmount(getDayRented());
	}
}
