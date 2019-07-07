package com.lsiqueira.planet.client;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class RequestWrapper {

		@JsonIgnoreProperties(ignoreUnknown = true)
		private ArrayList<Planet> results;

		public ArrayList<Planet> getResults() {
			return results;
		}

		public void setResults(ArrayList<Planet> results) {
			this.results = results;
		}
}
