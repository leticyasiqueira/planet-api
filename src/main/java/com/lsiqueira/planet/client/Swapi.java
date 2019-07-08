package com.lsiqueira.planet.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class Swapi {

	public ResponseEntity<RequestWrapper> getPlanetByName(String nome) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(constructHeaders());
		ResponseEntity<RequestWrapper> wrapper = null;

		try {

			wrapper = restTemplate.exchange("https://swapi.co/api/planets/?search=" + nome, HttpMethod.GET, entity,
					RequestWrapper.class);

		} catch (HttpStatusCodeException e) {
			throw new Exception("Error caling swapi: " + e);
		}

		return wrapper;
	}

	private HttpHeaders constructHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.USER_AGENT, "");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		return headers;
	}
}
