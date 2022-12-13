package com.lightcameraaction.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lightcameraaction.model.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{

	List<Movie> findByName(String name);
	void deleteMovieById(long id);
	
//	@Modifying
//	@Query("update Movie m set m.name = ?1, m.desciption = ?2, m.duration = ?3, m.releaseYear = ?4, m.type = ?5, m.image = ?6 where m.id = ?7")
//	void setMovieById(String name, String desciption, long duration, long releaseYear, String type, String image, long id);
}
