package com.lsiqueira.planet.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

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
import com.lsiqueira.planet.exception.PlanetBadRequestException;
import com.lsiqueira.planet.exception.PlanetNotFoundException;
import com.lsiqueira.planet.repository.PlanetRepository;
import com.lsiqueira.planet.service.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

	@Autowired
	private PlanetRepository planetRepository;

	@PostMapping
	public ResponseEntity<Void> createPlanet(@RequestBody @Valid Planet planet) throws Exception {

		Optional<Planet> searchPlanetName = planetRepository.findByName(planet.getName());

		if (searchPlanetName.isPresent()) {
			throw new PlanetBadRequestException("O planeta " + planet.getName() + " já está cadastrado!");
		}

		//PlanetService planetService = new PlanetService();
		//int film = planetService.searchFilms(planet.getName());
		//planet.setFilms(film);
		Planet savedPlanet = planetRepository.save(planet);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPlanet.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping()
	public ResponseEntity<?> getPlanet(@RequestParam(name = "pag", required = false, defaultValue = "0") int pag,
			@RequestParam(name = "size", required = false, defaultValue = "5") int size,
			@RequestParam(name = "name", required = false) String name) {

		Pageable pageable = PageRequest.of(pag, size, Sort.Direction.DESC, "name");

		if (name != null) {

			Optional<Planet> planet = planetRepository.findByName(name);

			if (!planet.isPresent()) {
				throw new PlanetNotFoundException("O planeta " + name + " não foi encontrado!");
			}

			return new ResponseEntity<Optional<Planet>>(planet, HttpStatus.OK);

		} else {

			return new ResponseEntity<Iterable<Planet>>(planetRepository.findAll(pageable), HttpStatus.OK);
		}

	}

	@GetMapping("{id}")
	public Planet getPlanetId(@PathVariable long id) {

		Optional<Planet> planet = validPlanetID(id);

		return planet.get();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Planet> delete(@PathVariable("id") long id) {

		validPlanetID(id);
		planetRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	private Optional<Planet> validPlanetID(long id) {

		Optional<Planet> searchPlanetID = planetRepository.findById(id);

		if (!searchPlanetID.isPresent()) {
			throw new PlanetNotFoundException("Id não encontrado!");
		}

		return searchPlanetID;
	}

}
