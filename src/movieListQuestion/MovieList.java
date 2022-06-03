package movieListQuestion;

import java.util.Map;
import java.util.TreeMap;

public class MovieList {

    private Map<String, String> movies;

    public MovieList(){
        movies = new TreeMap<String, String>();
    }

    public void addMovie(String movie) throws MovieListException {

        if (movies.containsKey(movie)){
            throw new MovieListException("Movie already exists");
        }

        movies.put(movie, "No rating");
    }

    public String getRating(String movie) throws MovieListException {

        if (!movies.containsKey(movie)){
            throw new MovieListException("Movie does not exist");
        }

        return movies.get(movie);
    }

    public void setRating(String movie, Stars rating) throws MovieListException {

        if (!movies.containsKey(movie)){
            throw new MovieListException("Movie does not exist");
        }

        movies.put(movie, rating.getRating());
    }

    public void setRating(String movie, Thumbs rating) throws MovieListException{

        if (!movies.containsKey(movie)){
            throw new MovieListException("Movie does not exist");
        }

        movies.put(movie, rating.getRating());
    }

    public String getList(){
        String list = "";

        for(String movie : movies.keySet()){
            list+= movie + "\n";
        }

        return list;
    }
}
