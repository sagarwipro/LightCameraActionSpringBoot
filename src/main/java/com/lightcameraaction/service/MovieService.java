package com.lightcameraaction.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lightcameraaction.exception.ItemNotFoundException;
import com.lightcameraaction.model.Movie;
import com.lightcameraaction.repo.MovieRepo;

@Service
public class MovieService {
	
	private final MovieRepo movieRepo;
	
	@Autowired
	public MovieService(MovieRepo movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}
	
	//Get All Movie
	public List<Movie> getAllMovie(){
		return movieRepo.findAll();
	}
	
	//Get By Id
	public Movie getMovieById(long id) {
		return movieRepo.findById(id).orElseThrow(() -> new ItemNotFoundException("Movie not found with the id : " + id));
	}
	
	//Get By name
	public List<Movie> getByName(String name){
		return movieRepo.findByName(name);
	}
	
	//Add Movie
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	//Update Movie
	public void updateMovie(Movie movie) {
//		movieRepo.setMovieById(movie.getName(), movie.getDescription(), movie.getDuration(), movie.getReleaseYear(), movie.getType().toString(), movie.getImage(), movie.getId());
		movieRepo.save(movie);
	}
	
	//Delete Movie
	public void deleteMovie(Movie movie) {
		movieRepo.delete(movie);
	}
}
