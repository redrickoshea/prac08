package movieListExercise2;

import java.util.Map;
import java.util.TreeMap;

import movieListExercise2.MovieListException;

/**
 * A class for maintaining a list of movies and associated ratings,
 * where ratings are in the range of 1 to 5 stars or -2 to +2 thumbs
 * up.
 * 
 * [This class is one possible answer to the second prac exercise.
 * Note the changes to method setRating.]
 * 
 *
 *
 *
 */
public class MovieList {

	Map<String, String> movieList; // mapping from movie name to rating

	public MovieList() {
		movieList = new TreeMap<String, String>(); // use tree map to sort by key
	}

	/**
	 * Adds a movie to the list.
	 * @param movieName the name of the new movie
	 * @throws MovieListException if the movie is already in the list
	 */
	public void addMovie(String movieName) throws MovieListException {
		if (movieList.containsKey(movieName))
			throw new MovieListException("Duplicate movie: " + movieName);
		else
			movieList.put(movieName, "No rating"); // default, dummy rating
	}

	/**
	 * Gets the rating associated with a particular movie.
	 * @param movieName the name of the movie whose rating we want
	 * @return the rating (in either stars or thumbs) associated with the movie,
	 * or "No rating" if the movie has not had a rating associated with it
	 * @throws MovieListException if the movie named is not in the list
	 */
	public String getRating(String movieName) throws MovieListException {
		if (movieList.containsKey(movieName))
			return movieList.get(movieName);
		else
			throw new MovieListException("No rating for movie: " + movieName);
	}

	/**
	 * Associates a rating (as a number of stars or thumbs) with a movie in the
	 * list
	 * @param movieName the name of the movie we want to rate
	 * @param numStars the number of stars or thumbs awarded to the named movie
	 * @throws MovieListException if the number of stars is not in the
	 * range 1 to 5 or if the number of thumbs is not in the range -2 to
	 * +2 or if the named movie is not in the list
	 */
	public void setRating(String movieName, Rating opinion) throws MovieListException {
		if (!movieList.containsKey(movieName))
			throw new MovieListException("Unknown movie: " + movieName);
		movieList.put(movieName, opinion.getRating());
	}

	/**
	 * Returns the movies in the list, sorted alphabetically.
	 * @return the list of movie names, one per line
	 */
	public String getList() throws MovieListException {
		String wholeList = "";
		for (String movieName : movieList.keySet()) { // ascending natural order
			wholeList += movieName + "\n"; 
		}
		return wholeList;
	}

}
