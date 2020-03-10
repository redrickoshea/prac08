package movieListExercise3;

/**
* A mock database of Academy Award winners
* 
* @author Colin Fidge
* @version 1.0
*/
public class OscarDB {

	public static boolean oscarWinner(String movieName) {
		return (movieName == "Casablanca" ||
				movieName == "Star Wars" ||
				movieName == "Citizen Kane");
	}
	
}
