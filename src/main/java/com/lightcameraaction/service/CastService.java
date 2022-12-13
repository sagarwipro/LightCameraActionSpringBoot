package com.lightcameraaction.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lightcameraaction.exception.ItemNotFoundException;
import com.lightcameraaction.model.Cast;
import com.lightcameraaction.repo.CastRepo;

@Service
public class CastService {

	private final CastRepo castRepo;

	@Autowired
	public CastService(CastRepo castRepo) {
		super();
		this.castRepo = castRepo;
	}
	
	//Get All Cast
	public List<Cast> getAllCast(){
		return castRepo.findAll();
	}
	
	//Get By Id
	public Cast getCastById(long id) {
		return castRepo.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found with the id : " + id));

	}
	
	//Get By name
	public List<Cast> getByName(String name){
		return castRepo.findByName(name);
	}
	
	//Add Cast
	public Cast addCast(Cast cast) {
		return castRepo.save(cast);
	}
	
	//Update Cast
	public Cast updateCast(Cast cast) {
		return castRepo.save(cast);
	}
	
	//Delete Cast
	public void deleteCastById(long id) {
		castRepo.deleteCastById(id);
	}
}
