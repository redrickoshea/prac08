package movieListQuestion;

public class Stars extends Rating{

    public Stars(int rating) throws MovieListException{

        if (rating < 1 || rating > 5){
            throw new MovieListException("Invalid rating");
        }

        String stars = "";

        for(int s = 0; s < rating; s++){
            stars+= "*";
        }

        this.rating = stars;
    }
}
