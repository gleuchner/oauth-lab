package de.hska.iwi.vislab.lab5.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "de.hska.iwi.vislab.lab5.web.controller")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
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
