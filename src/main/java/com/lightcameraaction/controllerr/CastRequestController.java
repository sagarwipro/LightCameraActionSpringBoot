package com.lightcameraaction.controllerr;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lightcameraaction.model.Cast;
import com.lightcameraaction.service.CastService;

@RestController
@RequestMapping("/casts")
public class CastRequestController {

	private CastService castService;
	
	public CastRequestController(CastService castService) {
		this.castService = castService;
	}
	
	@GetMapping
	public ResponseEntity<List<Cast>> getAllCasts(){
		List<Cast> casts = castService.getAllCast();
		return new ResponseEntity<>(casts,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cast> getCastById(@PathVariable("id") Long id){
		Cast cast = castService.getCastById(id);
		return new ResponseEntity<>(cast,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Cast> updateCast(@RequestBody Cast cast){
		Cast retCast = castService.updateCast(cast);
		return new ResponseEntity<>(retCast,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cast> addCast(@RequestBody Cast cast){
		Cast retCast = castService.addCast(cast);
		return new ResponseEntity<>(retCast, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCastById(@PathVariable("id") Long id) {
		castService.deleteCastById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
