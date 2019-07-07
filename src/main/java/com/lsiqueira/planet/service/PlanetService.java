package com.lsiqueira.planet.service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lsiqueira.planet.client.RequestWrapper;
import com.lsiqueira.planet.client.Swapi;

@Service
public class PlanetService {
	

	public void validPlanet(String name) throws Exception,NotFoundException {
		
		Swapi api = new Swapi();
		ResponseEntity<RequestWrapper> wrapper = api.getPlanetByName(name);
		
		if (wrapper.getBody().getResults().size() == 0) {
			
			throw new NotFoundException("O planeta não existe no mundo Star War", (Response) ResponseEntity.notFound());
		}
		
	
	}
	
	
}
