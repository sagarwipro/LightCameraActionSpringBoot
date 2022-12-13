package com.lightcameraaction.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Movie")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private long id;
	private String name;
	private String description;
	private String imageUrl;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "movie_casts",
	joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "cast_id"))
	private List<Cast> castList = new ArrayList<>();
	private long duration;
	private long releaseYear;
	@Enumerated(EnumType.STRING)
	private Genre type;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	public Movie(long id, String name, String description, String imageUrl, long duration, long releaseYear, Genre type) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.duration = duration;
		this.releaseYear = releaseYear;
		this.type = type;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return imageUrl;
	}
	public void setImage(String image) {
		this.imageUrl = image;
	}
	public List<Cast> getCastList() {
		return castList;
	}
	public void setCastList(List<Cast> castList) {
		this.castList = castList;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public long getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(long releaseYear) {
		this.releaseYear = releaseYear;
	}
	public Genre getType() {
		return type;
	}
	public void setType(Genre type) {
		this.type = type;
	}
	
	public void addCast(Cast cast) {
        castList.add(cast);
    }
 
    public void removeCast(Cast cast) {
        if(castList.contains(cast)) {
        	castList.remove(cast);
        }
    }
 
	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", image=" + imageUrl
				+ ", duration=" + duration + ", releaseYear=" + releaseYear + ", type=" + type + "]";
	} 
	
}
