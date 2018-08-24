package rentalstore;

public class Rental {
	private Movie movie;
	private int dayRented;
	private MovieType movieType;

	public Rental(Movie movie, int dayRented) {
		this.movie = movie;
		this.dayRented = dayRented;
		switch (movie.getPriceCode()) {
			case Movie.REGULAR:
				movieType = new Regular();
				break;
			case Movie.NEW_RELEASE:
				movieType = new NewRelease();
				break;
			case Movie.CHILDRENS:
				movieType = new Childrens();
				break;
		}
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
