package com.lightcameraaction.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lightcameraaction.model.Cast;

public interface CastRepo extends JpaRepository<Cast, Long>{

	List<Cast> findByName(String name);
	Optional<Cast>  deleteCastById(long id);
}
