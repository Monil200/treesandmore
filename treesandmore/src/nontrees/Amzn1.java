package nontrees;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Comparator;
class Movie {
    private float rating;
    private int movieId;
    public Movie(int mid, float r) {
        movieId = mid;
        rating = r;
    }
    public List<Movie> getSimilarMovies() {
        return null;
    }
    public float getRating() {
        return 0f;
    }
    public int getId() {
        return 0;
    }
}

class MovieRatingName extends Movie{
    int id;
    float rating;
    MovieRatingName(int mId, float r) {
        super(mId, r);
    }
}
public class Amzn1 {
    
    public static Set<Movie> getMovieRecommendations (Movie movie, int N) 
    {
        // WRITE YOUR CODE HERE
        List<Movie> similar = new ArrayList<Movie>();
        similar = movie.getSimilarMovies();
        if (similar == null || similar.size() == 0)
            return null;
        
        
        PriorityQueue<MovieRatingName> pq = new PriorityQueue<MovieRatingName>(new Comparator<MovieRatingName>() {
            public int compare(MovieRatingName a, MovieRatingName b) {
                if (b.rating > a.rating)
                    return 1;
                else if (b.rating < a.rating)
                    return -1;
                else
                    return 0;
            }
        });
        Set<Movie> result = new HashSet<Movie>();
        
        for(int i=0;i<similar.size();i++) {
            Movie m = similar.get(i);
            MovieRatingName obj = new MovieRatingName(m.getId(), m.getRating());
            pq.add(obj);
        } // added all rating floats elements in priority Q
        
        int limit = (N < pq.size()) ? N : pq.size();
        for(int i=0;i<limit;i++) {
            result.add(pq.poll());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Movie temp = new Movie(2,6f);
        Set<Movie> x = new HashSet<Movie>();
        x = getMovieRecommendations(temp, 8);
    }

}
