package com.lightcameraaction.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cast")
public class Cast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cast_id")
	private long id;
	private String name;
	@ManyToMany(mappedBy = "castList")
	private List<Movie> movies;
	private String birthPlace;
	private String imageUrl;
	

	public Cast(long id, String name, List<Movie> movies, String birthPlace, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.movies = movies;
		this.birthPlace = birthPlace;
		this.imageUrl=imageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Cast [id=" + id + ", name=" + name + ", movies=" + movies + ", birthPlace="
				+ birthPlace + ", imageUrl=" + imageUrl + "]";
	}
	
}
