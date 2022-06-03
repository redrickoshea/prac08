package movieListQuestion;

public class Thumbs extends Rating{

    public Thumbs(int rating) throws MovieListException{

        if (rating < -2 || rating > 2){
            throw new MovieListException("Invalid rating");
        }

        switch (rating){
            case -2: this.rating = "Two thumbs down"; break;
            case -1: this.rating = "One thumb down"; break;
            case 0: this.rating = "Neutral"; break;
            case 1: this.rating = "One thumb up"; break;
            case 2: this.rating = "Two thumbs up"; break;
        }
    }
}
