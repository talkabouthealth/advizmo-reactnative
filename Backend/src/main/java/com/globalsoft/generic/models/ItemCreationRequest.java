package com.globalsoft.generic.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ItemCreationRequest {

	@JsonProperty("client_id")
	private String clientId;
	@JsonProperty("secret")
	private String secret;
	@JsonProperty("public_token")
	private String publicToken;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ItemCreationRequest() {
	}

	/**
	 *
	 * @param publicToken
	 * @param clientId
	 * @param secret
	 */
	public ItemCreationRequest(String clientId, String secret, String publicToken) {
		super();
		this.clientId = clientId;
		this.secret = secret;
		this.publicToken = publicToken;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getPublicToken() {
		return publicToken;
	}

	public void setPublicToken(String publicToken) {
		this.publicToken = publicToken;
	}

	@Override
	public String toString() {
		return "{\"client_id\":\"" + clientId + "\",\"secret\":\"" + secret + "\",\"public_token\":\"" + publicToken
				+ "\"}";
	}

}