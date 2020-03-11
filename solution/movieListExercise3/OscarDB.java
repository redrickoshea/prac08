package movieListExercise3;

/**
* A mock database of Academy Award winners
* 
*
*
*/
public class OscarDB {

	public static boolean oscarWinner(String movieName) {
		return (movieName.Equals("Casablanca") ||
				movieName.Equals("Star Wars") ||
				movieName.Equals("Citizen Kane"));
	}
	
}
