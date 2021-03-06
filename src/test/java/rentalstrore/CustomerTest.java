package rentalstrore;


import org.junit.Test;
import rentalstore.*;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

	private Customer customer = new Customer("Jerry");

	@Test
	public void should_return_correct_statement_given_customer_has_no_rental() {
		String statement = customer.getTxtStatement();
		assertEquals("Recordntal Record for Jerry\nAmount owed is 0.0\nYou earned 0.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
		Movie regularMovie = new Movie("Titanic");
		Rental oneDayRental = new Rental(regularMovie, 1, new Regular());
		customer.addRental(oneDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + regularMovie.getTitle() + "\t2.0\n" +
				"Amount owed is 2.0\n" +
				"You earned 1.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
		Movie regularMovie = new Movie("Titanic");
		Rental threeDayRental = new Rental(regularMovie, 3, new Regular());
		customer.addRental(threeDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + regularMovie.getTitle() + "\t3.5\n" +
				"Amount owed is 3.5\n" +
				"You earned 1.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
		Movie newReleaseMovie = new Movie("Titanic");
		Rental oneDayRental = new Rental(newReleaseMovie, 1, new NewRelease());
		customer.addRental(oneDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
				"Amount owed is 3.0\n" +
				"You earned 1.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
		Movie newReleaseMovie = new Movie("Titanic");
		Rental twoDayRental = new Rental(newReleaseMovie, 2, new NewRelease());
		customer.addRental(twoDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
				"Amount owed is 6.0\n" +
				"You earned 2.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
		Movie childrenMovie = new Movie("Titanic");
		Rental oneDayRental = new Rental(childrenMovie, 1, new Childrens());
		customer.addRental(oneDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + childrenMovie.getTitle() + "\t1.5\n" +
				"Amount owed is 1.5\n" +
				"You earned 1.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
		Movie childrenMovie = new Movie("Titanic");
		Rental fourDayRental = new Rental(childrenMovie, 4, new Childrens());
		customer.addRental(fourDayRental);

		String statement = customer.getTxtStatement();

		assertEquals("Recordntal Record for Jerry\n" +
				"\t" + childrenMovie.getTitle() + "\t3.0\n" +
				"Amount owed is 3.0\n" +
				"You earned 1.0 frequent renter points", statement);
	}

	@Test
	public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
		Movie childrenMovie = new Movie("Titanic");
		Rental fourDayRental = new Rental(childrenMovie, 4,new Childrens());
		customer.addRental(fourDayRental);

		String statement = customer.getHtmlStatement();

		System.out.println(statement);

		assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
				"Titanic: 3.0<BR>\n" +
				"<P>You owe<EM>3.0</EM><P>\n" +
				"On this rental you earned <EM>1.0</EM> frequent renter points<P>", statement);
	}

	@Test
	public void should_return_correct_txt_statement_given_customer_has_rent_literary_movie_for_1_day() {
		Movie literaryMovie = new Movie("literary movie");
		Rental fourDayRental = new Rental(literaryMovie, 1,new Literary());
		customer.addRental(fourDayRental);

		String statement = customer.getHtmlStatement();

		System.out.println(statement);

		assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
				"literary movie: 6.0<BR>\n" +
				"<P>You owe<EM>6.0</EM><P>\n" +
				"On this rental you earned <EM>1.5</EM> frequent renter points<P>", statement);
	}


}
