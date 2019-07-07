package com.lsiqueira.planet.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lsiqueira.planet.entity.Planet;
import com.lsiqueira.planet.repository.PlanetRepository;
import com.lsiqueira.planet.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {
	
	@Autowired
	private PlanetRepository planetRepository;
	
	@Autowired
	private PlanetService planetService;

	
	@PostMapping
	public ResponseEntity<Planet> createPlanet(@RequestBody Planet planet) throws Exception {
		
		planetService.validPlanet(planet.getName());
		
		Planet savedPlanet = planetRepository.save(planet);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPlanet.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping()
	public ResponseEntity<Iterable<Planet>> getListPlanet(
			@RequestParam(name = "pag", required = false, defaultValue = "0") int pag,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size) {
		
		Pageable pageable = PageRequest.of(pag, size, Sort.Direction.DESC, "name");
		
		return new ResponseEntity<Iterable<Planet>>(planetRepository.findAll(pageable), HttpStatus.OK);

	}

	@GetMapping("{id}")
	public Planet getPlanet(@PathVariable long id) {
		Optional<Planet> planet = planetRepository.findById(id);
		 
		return planet.get();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Planet> delete(@PathVariable("id") long id){
		planetRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
