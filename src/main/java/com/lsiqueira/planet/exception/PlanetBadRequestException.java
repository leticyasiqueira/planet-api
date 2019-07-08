package com.lsiqueira.planet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlanetBadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetBadRequestException(String exception) {
		super(exception);
	}

}
