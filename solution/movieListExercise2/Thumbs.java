package movieListExercise2;

/**
 * A class for movie ratings expressed in a range from "two thumbs up"
 * to "two thumbs down".
 * 
 *
 *
 */
public class Thumbs implements Rating {

	private String thumbs; // store the rating as a printable string

	public Thumbs(int rating) throws MovieListException {
		if (rating < -2 || rating > 2)
			throw new MovieListException("Illegal number of thumbs: " + rating);
		else
			switch (rating) {
			case -2: thumbs = "Two thumbs down"; break;
			case -1: thumbs = "One thumb down"; break;
			case 0:  thumbs = "No thumbs (neutral)"; break;
			case 1:  thumbs = "One thumb up"; break;
			case 2:  thumbs = "Two thumbs up"; break;
			}
	}

	public String getRating() {
		return thumbs;
	}


}

