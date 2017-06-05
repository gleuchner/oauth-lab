package de.hska.iwi.vislab.lab5.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableOAuth2Client
public class OAuthConfig {

	@Value("${OAuth2ClientId}")
	private String oAuth2ClientId;

	@Value("${OAuth2ClientSecret}")
	private String oAuth2ClientSecret;

	// @Value("${Oauth2AccesTokenUri}")
	@Value("${oauth.token:http://localhost:8080/oauth/token}")
	private String accessTokenUri;

	@Bean
	public RestTemplate oAuthRestTemplate() {
		ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
		resourceDetails.setId("1");
		resourceDetails.setClientId(oAuth2ClientId);
		resourceDetails.setClientSecret(oAuth2ClientSecret);
		resourceDetails.setAccessTokenUri(accessTokenUri);
		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		resourceDetails.setScope(scopes);

		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());

		return restTemplate;
	}
}