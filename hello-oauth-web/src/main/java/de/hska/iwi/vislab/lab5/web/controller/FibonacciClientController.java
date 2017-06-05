package de.hska.iwi.vislab.lab5.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Client
@RestController
public class FibonacciClientController {

	@Value("${oauth.resource:http://localhost:8080}")
	private String baseUrl;

	@Autowired
	private OAuth2RestOperations restTemplate;

	@RequestMapping(path = "/fibonacci", method = RequestMethod.PUT)
	public ResponseEntity<String> setSequenceNumber(@RequestBody Long seq) {
		restTemplate.put(baseUrl + "/fibonacci", seq);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(path = "/fibonacci", method = RequestMethod.GET)
	public ResponseEntity<String> getSequenceNumber() {
		String forObject = restTemplate.getForObject(baseUrl + "/fibonacci", String.class);
		return new ResponseEntity<String>(forObject, HttpStatus.OK);
	}

	@RequestMapping(path = "/fibonacci", method = RequestMethod.DELETE)
	public ResponseEntity<String> resetSequenceNumber() {
		restTemplate.delete(baseUrl + "/fibonacci");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
