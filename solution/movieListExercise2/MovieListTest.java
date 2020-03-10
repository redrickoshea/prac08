package movieListExercise2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/* The following tests are for the movie list class
 * extended with the ability to rate movies in thumbs
 * 
 * Some of the existing tests have been changed, because
 * the type for expressing ratings has been changed
 * 
 * Also some entirely new tests associated with "thumbs"
 * ratings have been added
 */

public class MovieListTest {

	/* Test 0: Declaring MovieList objects
	 */
	MovieList movies;
	

	/* Test 1: Constructing a MovieList object
	 */
	@BeforeEach @Test public void setUpMovieList() {
		movies = new MovieList();
	}
	
	/* Test 2: Adding a new movie to the list
	 */
	@Test public void addAMovie() throws MovieListException {
		movies.addMovie("Star Wars");
		assertEquals("No rating", movies.getRating("Star Wars"),
				"Adding movie failed");
	}
	
	/* Test 3: Associating a rating with a movie
	 */
	@Test public void setARating() throws MovieListException {
	movies.addMovie("Goldfinger");
	movies.setRating("Goldfinger", new Stars(4)); // <-- test changed
	assertEquals("****", movies.getRating("Goldfinger"),
			"Couldn't set a rating");
}
	
	/* Test 4: Getting a printable list of movies
	 */
	@Test public void listAlphabetically() throws MovieListException {
		String orderedListing =
				"Casablanca\n" +
				"Maltese Bippy, The\n" +
				"Star Wars\n";
		movies.addMovie("Star Wars");
		movies.addMovie("Casablanca");
		movies.addMovie("Maltese Bippy, The");
		assertEquals(orderedListing, movies.getList(),
				"Listing not alphabetical");
	}
	
	/* Test 5: Can't get a rating for an unrated movie
	 */
	@Test
	public void nonexistentRating() {
		assertThrows(MovieListException.class, () -> {
			movies.getRating("The Ghost in the Invisible Bikini");
		});
	}
	
	/* Test 6: Can't add the same movie twice
	 */
	@Test
	public void duplicateMovie() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Earth Versus the Flying Saucers");
			movies.addMovie("Earth Versus the Flying Saucers");
		});
	}
	
	/* Test 7: Even a bomb gets a single star
	 */
	@Test
	public void ratingTooLow() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Plan Nine From Outer Space");
			movies.setRating("Plan Nine From Outer Space", new Stars(0)); // <-- test changed
		});
	}
	
	/* Test 8: No movie gets more than five stars
	 */
	@Test
	public void ratingTooHigh() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Citizen Kane");
			movies.setRating("Citizen Kane", new Stars(6)); // <-- test changed
		});
	}
	
	/* Test 9: Can't rate an unknown movie
	 */
	@Test
	public void ratingUnknownMovie() {
		assertThrows(MovieListException.class, () -> {
			movies.setRating("Them!", new Stars(4)); // <-- test changed
		});
	}
	
	/* ----------  New tests ---------- */
	
	/* Test 10: Confirm that ratings can be stored as a number
	 * of thumbs
	 * [This test obliges you to create the new class "Thumbs", which
	 * can be used as the second parameter to method setRating.  This
	 * change to setRating's signature also forces us to change all
	 * the previous tests involving setRatings (tests 3, 7, 8 and 9
	 * above).  Since ratings can now be expressed as either a
	 * number of stars or thumbs in the tests, we are forced to
	 * create a type hierarchy in which classes "Thumbs" and "Stars"
	 * are subclasses of the same superclass (which we've called
	 * "Rating").]
	 * 
	 */
	@Test public void setOneThumbUp() throws MovieListException {
		movies.addMovie("What's New Pussycat?");
		movies.setRating("What's New Pussycat?", new Thumbs(1));
		assertEquals("One thumb up", movies.getRating("What's New Pussycat?"),
				"Couldn't set a one thumb up rating");
	}
	
	/* Observation: Because there is a simple relationship between the
	 * numbers 1 to 5 and the ratings "*" to "*****", it was sufficient
	 * to have a single test for establishing the link between a
	 * numerical score and the number of stars (Test 3, above).
	 * However, the string to be returned for each of the "thumbs"
	 * ratings from -2 to +2 is different.  This is evidenced by the
	 * switch statement in the Thumbs class.  For completeness,
	 * therefore, we need a separate test for each "thumbs" rating
	 * to define which string should be returned for each value.  This
	 * is an example of glass box unit testing.  The switch statement
	 * in the code alerts us to the fact that we're dealing with five
	 * distinct cases, each of which needs to be exercised to get full
	 * code coverage.
	 */
	
	/* Test 11: Two thumbs up
	 */
	@Test public void setTwoThumbsUp() throws MovieListException {
		movies.addMovie("Ghostbusters");
		movies.setRating("Ghostbusters", new Thumbs(2));
		assertEquals("Two thumbs up", movies.getRating("Ghostbusters"),
				"Couldn't set a two thumbs up rating");
	}
	
	/* Test 12: No thumbs
	 */
	@Test public void setNoThumbs() throws MovieListException {
		movies.addMovie("The Ghost of Frankenstein");
		movies.setRating("The Ghost of Frankenstein", new Thumbs(0));
		assertEquals("No thumbs (neutral)", movies.getRating("The Ghost of Frankenstein"),
				"Couldn't set a neutral rating");
	}	
	
	/* Test 13: One thumb down
	 */
	@Test public void setOneThumbDown() throws MovieListException {
		movies.addMovie("Hold On!");
		movies.setRating("Hold On!", new Thumbs(-1));
		assertEquals("One thumb down", movies.getRating("Hold On!"),
				"Couldn't set a one thumb down rating");
	}	
	
	/* Test 14: Two thumbs down
	 */
	@Test public void setTwoThumbsDown() throws MovieListException {
		movies.addMovie("Plan Nine From Outer Space");
		movies.setRating("Plan Nine From Outer Space", new Thumbs(-2));
		assertEquals("Two thumbs down", movies.getRating("Plan Nine From Outer Space"),
				"Couldn't set a two thumbs down rating");
	}
	
	/* Test 15: Even a bomb gets only two thumbs down
	 * [This test establishes the lower bound on the number of thumbs.
	 * (Again we are inferring that all values below -2 are excluded,
	 * not just -3.)]
	 */
	@Test
	public void TooFewThumbsUp() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Plan Nine From Outer Space");
			movies.setRating("Plan Nine From Outer Space", new Thumbs(-3));
		});
	}
	
	/* Test 16: No movie gets more than two thumbs up
	 * [This test establishes the upper bound on the number of thumbs.]
	 */
	@Test
	public void TooManyThumbsUp() {
		assertThrows(MovieListException.class, () -> {
			movies.addMovie("Citizen Kane");
			movies.setRating("Citizen Kane", new Thumbs(3));
		});
	}
}
