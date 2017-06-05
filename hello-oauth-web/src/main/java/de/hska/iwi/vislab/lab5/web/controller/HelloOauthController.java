package de.hska.iwi.vislab.lab5.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableOAuth2Client
@RestController
public class HelloOauthController {
	@Value("${oauth.resource:http://localhost:8080}")
	private String baseUrl;
	//
	// @Value("${oauth.authorize:http://localhost:8080/oauth/authorize}")
	// private String authorizeUrl;
	//
	// @Value("${oauth.token:http://localhost:8080/oauth/token}")
	// private String tokenUrl;

	@Autowired
	private OAuth2RestOperations restTemplate;

	@RequestMapping("/")
	public String home() {
		return "greet";
	}

	@RequestMapping("/greet")
	public String next(Model model) {
		String hello = restTemplate.getForObject(baseUrl + "/hello", String.class);
		model.addAttribute("greet", hello);
		return "greet";
	}

	// @Bean
	// public OAuth2RestOperations restTemplate(OAuth2ClientContext
	// oauth2ClientContext) {
	// return new OAuth2RestTemplate(resource(), oauth2ClientContext);
	// }
	//
	// @Bean
	// protected OAuth2ProtectedResourceDetails resource() {
	// AuthorizationCodeResourceDetails resource = new
	// AuthorizationCodeResourceDetails();
	// resource.setAccessTokenUri(tokenUrl);
	// resource.setUserAuthorizationUri(authorizeUrl);
	// resource.setClientId("my-trusted-client");
	// return resource;
	// }
}
