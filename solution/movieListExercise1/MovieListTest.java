package movieListExercise1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/* The following tests are for the basic functionality of
 * the movie list class
 * 
 * Here we have added comments to explain what each test
 * obliges you to do during Test-Driven Development
 */

public class MovieListTest {

	/* Test 0: Declaring MovieList objects
	 * [This test obliges you to create a class called "MovieList".]
	 */
	MovieList movies;
	

	/* Test 1: Constructing a MovieList object
	 * [This test obliges your to add a parameterless constructor
	 * to your MovieList class.]
	 */
	@BeforeEach @Test
	public void setUpMovieList() {
		movies = new MovieList();
	}
	
	/* Test 2: Adding a new movie to the list
	 * [This test obliges you to add methods called "addMovie"
	 * and "getRating".  (For now, only getRating needs to
	 * so anything, and all it needs to do is return the
	 * string "No rating".)] 
	 */
	@Test
	public void addAMovie() throws MovieListException {
		movies.addMovie("Star Wars");
		assertEquals("No rating", movies.getRating("Star Wars"),
				"Adding movie failed");
	}
	
	/* Test 3: Associating a rating with a movie
	 * [This test obliges you to add a method called "setRating".
	 * Also, since the value "****" returned by getRating is
	 * related to the value 4 accepted by setRating, you must
	 * eliminate this duplication by storing the rating
	 * associated with a particular movie in a private data
	 * structure.]
	 */
	@Test
	public void setARating() throws MovieListException {
		movies.addMovie("Goldfinger");
		movies.setRating("Goldfinger", 4);
		assertEquals("****", movies.getRating("Goldfinger"),
				"Couldn't set a rating");
	}
	
	/* Test 4: Getting a printable list of movies
	 * [This test obliges you to add a method called "getList".
	 * Since the value returned by getList can be derived from the
	 * values provided previously to method addMovie, by sorting
	 * the movie names alphabetically, you must also eliminate
	 * this duplication (either by storing the movies in
	 * alphabetical order or by sorting them when asked to get
	 * the list).]
	 */
	@Test
	public void listAlphabetically() throws MovieListException {
		String orderedListing =
				"Casablanca\n" +
				"Maltese Bippy, The\n" +
				"Star Wars\n";
		movies.addMovie("Star Wars");
		movies.addMovie("Casablanca");
		movies.addMovie("Maltese Bippy, The");
		assertEquals(orderedListing, movies.getList(), "Listing not alphabetical");
	}
	
	/* Test 5: Can't get a rating for an unrated movie
	 * [This test obliges method getRating to throw an exception
	 * for a movie which has not previously been added to the
	 * list.]
	 */
	@Test
	public void nonexistentRating() {
		assertThrows(MovieListException.class, () -> {
			movies.getRating("The Ghost in the Invisible Bikini");
		});
	}
	
	/* Test 6: Can't add the same movie twice
	 * [This test obliges method addMovie to throw an exception
	 * if it is given the same movie name more than once.]
	 */
	@Test
	public void duplicateMovie() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Earth Versus the Flying Saucers");
			movies.addMovie("Earth Versus the Flying Saucers");
		});
	}
	
	/* Test 7: Even a bomb gets a single star
	 * [This test obliges method setRating to throw an exception
	 * if the number of stars associated with a movie is zero or less.
	 * (From our knowledge of the intended application, we infer
	 * that values below zero should throw an exception as well.)] 
	 */
	@Test
	public void ratingTooLow() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Plan Nine From Outer Space");
			movies.setRating("Plan Nine From Outer Space", 0);
		});
	}
	
	/* Test 8: No movie gets more than five stars
	 * [This test obliges method setRating to throw an exception
	 * if the number of stars is greater than six or more.  (Again,
	 * we exploit our understanding of the intended application to
	 * recognise that numbers above six should also cause
	 * exceptions to be thrown.)]
	 */
	@Test
	public void ratingTooHigh() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Citizen Kane");
			movies.setRating("Citizen Kane", 6);
		});
	}
	
	/* Test 9: Can't rate an unknown movie
	 * [This test obliges method setRating to throw an exception if
	 * it is asked to set the rating for a movie that has not
	 * been added to the list previously.]
	 */
	@Test
	public void ratingUnknownMovie() {
		assertThrows(MovieListException.class, () -> {
			movies.setRating("Them!", 4);
		});
	}
	
}
