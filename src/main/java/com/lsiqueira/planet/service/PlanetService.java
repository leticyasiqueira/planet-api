package com.lsiqueira.planet.service;

import javax.ws.rs.BadRequestException;

import org.springframework.http.ResponseEntity;

import com.lsiqueira.planet.client.RequestWrapper;
import com.lsiqueira.planet.client.Swapi;
import com.lsiqueira.planet.exception.PlanetBadRequestException;

public class PlanetService {

	public int searchFilms(String name) throws Exception, BadRequestException {

		int films;
		Swapi api = new Swapi();

		ResponseEntity<RequestWrapper> wrapper = api.getPlanetByName(name);

		if (wrapper.getBody().getResults().size() == 0) {

			throw new PlanetBadRequestException("O planeta " + name + " é inválido para o mundo do StarWar!");
			
		} else {
			
			films = wrapper.getBody().getResults().get(0).getFilms().size();
		}

		return films;

	}

}
