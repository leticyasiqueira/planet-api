package com.lsiqueira.planet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Planet {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "{name.not.blank}")
	private String name;
	
	@NotBlank(message = "{climate.not.blank}")
	private String climate;
	
	@NotBlank(message = "{terrain.not.blank}")
	private String terrain;
	
	private int films;

	public Planet() {
		//Auto-generated constructor stub
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

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public int getFilms() {
		return films;
	}

	public void setFilms(int films) {
		this.films = films;
	}
	
	
	
}
