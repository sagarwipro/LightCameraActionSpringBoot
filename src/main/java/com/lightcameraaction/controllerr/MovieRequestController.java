package com.lightcameraaction.controllerr;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lightcameraaction.model.Movie;
import com.lightcameraaction.service.MovieService;



@RestController
@RequestMapping("/movies")
//RequestMapping tells this is the thing we need to add with url to request and response.
@CrossOrigin(origins = "*")
public class MovieRequestController {

	private MovieService movieService;
	
	@Autowired
	public MovieRequestController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	
	@GetMapping
/*	Response entity is a class which is type of http request retrieval body 
	that means response to the call of this method */
	public ResponseEntity<List<Movie>> getAllMovies(){
		List<Movie> movies = movieService.getAllMovie();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	//we should use path variable if we need to attain variable in URL
	//We use "var" to tell this is the variable name in the path then data type like 
	//Long and put the name to call 
	//To access url (head) variable we can use @PathVariable
		public ResponseEntity<Movie> getMovieById(@PathVariable long id){
			Movie movie = movieService.getMovieById(id);
			return new ResponseEntity<>(movie, HttpStatus.OK);
		}
	
	@PostMapping
	//In para we are expecting Movie object in JSON format
	//To access body of the request we use @RRequestBody
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
		Movie movieReturned = movieService.addMovie(movie);
		
		return new ResponseEntity<>(movieReturned, HttpStatus.CREATED);
	}

//	@PutMapping()
//	public void updateMovie(@RequestBody Movie movie){
//		System.out.println(movie.getName()+ "from server controller");
//		movieService.updateMovie(movie);
//	}
	
	@PutMapping
	public void updateMovie(@RequestBody Movie movie){
		System.out.println("Update method calleds");
		movieService.updateMovie(movie);
	}
	

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable long id) {
		Movie movie = movieService.getMovieById(id);
		if(movie!=null) {
			movieService.deleteMovie(movie);
		}
	}
	
}
